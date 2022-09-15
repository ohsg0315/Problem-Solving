import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int MAX_ROW, MAX_COLUMN;
    int[] dr = new int[]{0, 0, -1, 1};
    int[] dc = new int[]{-1, 1, 0, 0};
    boolean[][] visited;

    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        MAX_ROW = grid.length;
        MAX_COLUMN = grid[0].length;
        visited = new boolean[MAX_ROW][MAX_COLUMN];

        for (int row = 0; row < MAX_ROW; row++) {
            for (int column = 0; column < MAX_COLUMN; column++) {
                if (grid[row][column] == 1 && !visited[row][column]) {
                    result = Math.max(result, bfs(grid, row, column));
                }
            }
        }

        return result;
    }

    private int bfs(int[][] grid, int row, int column) {
        int result = 0;
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{row, column});
        visited[row][column] = true;

        while (!queue.isEmpty()) {
            result++;
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextR = now[0] + dr[i];
                int nextC = now[1] + dc[i];

                if (isRange(nextR, nextC) && !visited[nextR][nextC] && grid[nextR][nextC] == 1) {
                    visited[nextR][nextC] = true;
                    queue.offer(new int[]{nextR, nextC});
                }
            }
        }
        return result;
    }

    private boolean isRange(int row, int column) {
        return 0 <= row && row < MAX_ROW && 0 <= column && column < MAX_COLUMN;
    }

}