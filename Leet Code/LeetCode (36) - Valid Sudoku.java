class Solution {
    private boolean checkSquare(char[][] board, int startX, int startY, int endX, int endY) {
        boolean[] check = new boolean[10];

        for (int y = startY; y < endY; y++) {
            for (int x = startX; x < endX; x++) {
                int number = Math.max(board[y][x] - '0', 0);

                if (check[number]) {
                    return false;
                }
                check[number] = number != 0;
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[][] checked = new boolean[2][10];

            for (int j = 0; j < 9; j++) {
                int horizontal = Math.max(board[i][j] - '0', 0);
                int vertical = Math.max(board[j][i] - '0', 0);

                if (checked[0][horizontal] || checked[1][vertical]) {
                    return false;
                }

                checked[0][horizontal] = horizontal != 0;
                checked[1][vertical] = vertical != 0;
            }
        }

        for (int y = 0; y < 9; y += 3) {
            for (int x = 0; x < 9; x += 3) {
                if (!checkSquare(board, x, y, x + 3, y + 3)) {
                    return false;
                }
            }
        }
        return true;
    }
}