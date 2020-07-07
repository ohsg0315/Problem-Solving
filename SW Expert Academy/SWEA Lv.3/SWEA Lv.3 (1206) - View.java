import java.util.*;

public class Solution {
    private static boolean isPossible(boolean[][] board, int x, int y) {
        int[] range = {-2, -1, 1, 2};

        for (int i = 0; i < 4; i++) {
            if ((board[y][x + range[i]])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int testCase = 1; testCase <= 10; testCase++) {
            int N = sc.nextInt(), res = 0;
            boolean[][] board = new boolean[255][N];

            for (int i = 0; i < N; i++) {
                int buf = sc.nextInt();

                if (buf != 0) {
                    for (int j = 0; j < buf; j++) {
                        board[j][i] = true;
                    }
                }
            }

            for (int i = 0; i < 255; i++) {
                for (int j = 2; j < N - 2; j++) {
                    if (board[i][j] && isPossible(board, j, i)) {
                        res++;
                    }
                }
            }
            System.out.println("#" + testCase + " " + res);
        }
    }
}