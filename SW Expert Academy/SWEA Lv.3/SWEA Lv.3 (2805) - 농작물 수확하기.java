import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt(), mid = N / 2, res = 0;
            int[][] board = new int[N][N];

            for (int i = 0; i < N; i++) {
                String buf = sc.next();
                board[i] = Arrays.stream(buf.split("")).mapToInt(Integer::parseInt).toArray();
            }
            for (int i = 0; i < N; i++) {
                int yRange = Math.abs(Math.abs(mid - i) - mid);

                res += board[mid][i];
                for (int j = 1; j <= yRange; j++) {
                    res += board[mid - j][i];
                    res += board[mid + j][i];
                }
            }
            System.out.println("#" + testCase + " " + res);
        }
    }
}