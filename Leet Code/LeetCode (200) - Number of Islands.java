import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private static int m , n;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private boolean isRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    private void BFS(char[][] grid, int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];

                if (!isRange(nextX, nextY) || grid[nextY][nextX] != '1') {
                    continue;
                }

                grid[nextY][nextX] = '0';
                queue.add(new Point(nextX, nextY));
            }
        }
    }

    public int numIslands(char[][] grid) {
        int result = 0;
        m = grid.length;
        n = grid[0].length;

        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (grid[y][x] == '1') {
                    result++;
                    BFS(grid, x, y);
                }
            }
        }

        return result;
    }
}