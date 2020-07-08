import java.util.*;

public class Solution {
    private static int N, res;

    private static boolean isPossible(int[] board, int row) {
        for (int i = 0; i < row; i++) {
            // 세로에서 겹치는 경우
            if (board[i] == board[row]) {
                return false;
            }
            // 대각선에서 겹치는 경우
            if (Math.abs(row - i) == Math.abs(board[row] - board[i])) {
                return false;
            }
        }
        return true;
    }

    private static void backTracking(int[] board, int row) {
        // column = N -> 모든 퀸을 두었다.
        if (row == N) {
            res++;
            return;
        }
        //
        for (int i = 0; i < N; i++) {
            board[row] = i;
            if (isPossible(board, row)) {
                backTracking(board, row + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            res = 0;
            N = sc.nextInt();
            int[] board = new int[N];

            backTracking(board, 0);
            System.out.println("#" + testCase + " " + res);
        }
    }
}