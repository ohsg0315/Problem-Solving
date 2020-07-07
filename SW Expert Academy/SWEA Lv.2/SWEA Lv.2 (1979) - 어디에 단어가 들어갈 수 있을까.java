import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;

        T = sc.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt(), K = sc.nextInt(), res = 0;
            int[][] board = new int[N][N];
            String[][] line = new String[2][N];
            StringBuilder sb = new StringBuilder();

            // 가로 한 줄씩 line[0]에 저장
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    board[i][j] = sc.nextInt();
                    sb.append(board[i][j]);
                }
                line[0][i] = sb.toString();
                sb.delete(0, sb.length());
            }
            // 세로 한 줄씩 line[1]에 저장
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(board[j][i]);
                }
                line[1][i] = sb.toString();
                sb.delete(0, sb.length());
            }

            // answer 생성
            for (int i = 0; i < K; i++) {
                sb.append("1");
            }
            String answer = sb.toString();

            // line에서 answer과 같다면 res++
            for (int i = 0; i < N; i++) {
                String[] arr = line[0][i].split("0");
                for (String buf : arr) {
                    if (buf.equals(answer)) {
                        res++;
                    }
                }
                arr = line[1][i].split("0");
                for (String buf : arr) {
                    if (buf.equals(answer)) {
                        res++;
                    }
                }
            }
            System.out.println("#" + testCase + " " + res);
        }
    }
}