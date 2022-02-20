import java.util.ArrayList;
import java.util.List;

class Solution {

    private static int n;
    private static List<List<String>> result;

    private static void nQueen(int[] board, int row) {
        if (row == n) {
            List<String> buffer = new ArrayList<>();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(board[i] == j ? 'Q' : '.');
                }
                buffer.add(sb.toString());
                sb.setLength(0);
            }

            result.add(buffer);
            return;
        }

        boolean isPossible;
        for (int i = 0; i < n; i++) {
            isPossible = true;
            board[row] = i;

            for (int j = 0; j < row; j++) {
                if (board[row] == board[j] || row - j == Math.abs(board[row] - board[j])) {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                nQueen(board, row + 1);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        result = new ArrayList<>();
        int[] board = new int[n];

        nQueen(board, 0);

        return result;
    }
}