class Solution {
    private static int N, M;
    private static final int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    private static final int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    private boolean isRange(int x, int y) {
        return 0 <= x && x < M && 0 <= y && y < N;
    }
    
    public void gameOfLife(int[][] board) {
        N = board.length;
        M = board[0].length;
        int[][] result = new int[N][M];

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                int cnt = 0;

                for (int i = 0; i < 8; i++) {
                    int nextX = x + dx[i];
                    int nextY = y + dy[i];

                    if (!isRange(nextX, nextY)) {
                        continue;
                    }

                    if (board[nextY][nextX] == 1) {
                        cnt++;
                    }
                }

                if (board[y][x] == 1) {
                    if (cnt == 2 || cnt == 3) {
                        result[y][x] = 1;
                    } else {
                        result[y][x] = 0;
                    }
                } else {
                    if (cnt == 3) {
                        result[y][x] = 1;
                    }
                }
            }
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                board[y][x] = result[y][x];
            }
        }
    }
}