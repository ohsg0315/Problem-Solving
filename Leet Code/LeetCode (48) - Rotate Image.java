class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] buf = new int[n][n];

        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                buf[row][column] = matrix[n - column - 1][row];
            }
        }

        for (int row = 0; row < n; row++) {
            System.arraycopy(buf[row], 0, matrix[row], 0, n);
        }
    }
}