import java.util.*;

public class Solution {
    private static void rotateBoard(int[][][] board, int N) {

/*
        0 0 / 0 1 / 0 2 / 0 3
        1 0 / 1 1 / 1 2 / 1 3
        2 0 / 2 1 / 2 2 / 2 3
        3 0 / 3 1 / 3 2 / 3 3

        3 0 / 2 0 / 1 0 / 0 0
        3 1 / 2 1 / 1 1 / 0 1
        3 2 / 2 2 / 1 2 / 0 2
        3 3 / 2 3 / 1 3 / 0 3

        [i][j] -> [N - 1 - j][i]
*/

        for (int k = 1; k < 4; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    board[k][i][j] = board[k - 1][N - 1 - j][i];
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;

        T = sc.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt();
            int[][][] board = new int[4][N][N];
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    board[0][i][j] = sc.nextInt();
                }
            }
            rotateBoard(board, N);

            System.out.println("#" + testCase);
            for (int i = 0; i < N; i++) {
                for (int k = 1; k < 4; k++) {
                    for (int j = 0; j < N; j++) {
                        sb.append(board[k][i][j]);
                    }
                    sb.append(" ");
                }
                System.out.println(sb.toString());
                sb.delete(0, sb.length());
            }
        }
    }
}