class Solution {
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private boolean isRange(int x, int y, int n) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        int x = 0, y = 0, direction = 0, cnt = 1;

        while (cnt <= n * n) {
            result[y][x] = cnt++;

            int nextX = x + dx[direction];
            int nextY = y + dy[direction];

            if (!isRange(nextX, nextY, n) || result[nextY][nextX] != 0) {
                direction = (direction + 1) % 4;

                nextX = x + dx[direction];
                nextY = y + dy[direction];
            }

            x = nextX;
            y = nextY;
        }

        return result;
    }
}