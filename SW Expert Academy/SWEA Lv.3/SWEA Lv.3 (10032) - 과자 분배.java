import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt(), K = sc.nextInt(), res;

            // 과자를 나누어 떨어지게 줄 수 있다 -> 0, 아니면 -> 1
            if (N % K == 0) {
                res = 0;
            } else {
                res = 1;
            }
            System.out.println("#" + testCase + " " + res);
        }
    }
}