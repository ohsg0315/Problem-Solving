import java.util.*;

public class Solution {
    private static int isRight(int[][] board) {
        boolean[] number;


        for (int i = 0; i < 9; i++) {
            // 가로 검사
            number = new boolean[10];

            for (int j = 0; j < 9; j++) {
                if (!number[board[i][j]]) {
                    number[board[i][j]] = true;
                } else {
                    return 0;
                }
            }
            // 세로 검사
            number = new boolean[10];
    
            for (int j = 0; j < 9; j++) {
                if (!number[board[j][i]]) {
                    number[board[j][i]] = true;
                } else {
                    return 0;
                }
            }
        }
        // 3 X 3 검사
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                number = new boolean[10];

                for (int r = i; r < i + 3; r++) {
                    for (int c = j; c < j + 3; c++) {
                        if (!number[board[r][c]]) {
                            number[board[r][c]] = true;
                        } else {
                            return 0;
                        }
                    }
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;

        T = sc.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int[][] board = new int[9][9];

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    board[i][j] = sc.nextInt();
                }
            }
            System.out.println("#" + testCase + " " + isRight(board));
        }
    }
}
