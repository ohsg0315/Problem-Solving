import java.util.*;

public class Solution {
    private static boolean isPalindrome(String s, int len) {
        if (len % 2 == 0) {
            len--;
            for (int i = 0; i <= len / 2; i++) {
                if (s.charAt(i) != s.charAt(len - i)) {
                    return false;
                }
            }
        } else {
            len--;
            for (int i = 0; i < len / 2; i++) {
                if (s.charAt(i) != s.charAt(len - i)) {
                    return false;
                }
            }
        }
        return true;
    }

    /*
        숫자 단위가 커졌으면 시간초과로 통과 못 했을것 같다.
        2차원 배열로 한 번에 가로, 세로 검사하는 방법 생각하기.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for (int testCase = 1; testCase <= T; testCase++) {
            int len = sc.nextInt(), res = 0;
            String[][] board = new String[2][8];

            // 가로
            for (int i = 0; i < 8; i++) {
                board[0][i] = sc.next();
            }
            // 세로
            for (int i = 0; i < 8; i++) {
                StringBuilder sb;
                for (int j = 0; j < 8; j++) {
                    sb = new StringBuilder();
                    for (int k = 0; k < 8; k++) {
                        sb.append(board[0][k].charAt(j));
                    }
                    board[1][j] = sb.toString();
                }
            }

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 8; j++) {
                    for (int k = 0; k <= 8 - len; k++) {
                        String s = board[i][j].substring(k, k + len);

                        if (isPalindrome(s, len)) {
                            res++;
                        }
                    }
                }
            }
            System.out.println("#" + testCase + " " + res);
        }
    }
}