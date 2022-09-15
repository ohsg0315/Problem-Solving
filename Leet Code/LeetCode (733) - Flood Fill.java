import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class Point {
        int row;
        int column;

        public Point(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};
        int maxRow = image.length, maxColumn = image[0].length, standardColor = image[sr][sc];
        boolean[][] visited = new boolean[maxRow][maxColumn];
        int[][] result = new int[maxRow][maxColumn];

        //Deep Copy
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxColumn; j++) {
                result[i][j] = image[i][j];
            }
        }

        //BFS
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(sr, sc));
        visited[sr][sc] = true;
        result[sr][sc] = color;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = now.row + dr[i];
                int nextColumn = now.column + +dc[i];

                if (nextRow < 0 || nextRow >= maxRow || nextColumn < 0 || nextColumn >= maxColumn) {
                    continue;
                }

                if (!visited[nextRow][nextColumn] && image[nextRow][nextColumn] == standardColor) {
                    result[nextRow][nextColumn] = color;
                    visited[nextRow][nextColumn] = true;
                    queue.offer(new Point(nextRow, nextColumn));
                }

            }
        }
        return result;
    }
}