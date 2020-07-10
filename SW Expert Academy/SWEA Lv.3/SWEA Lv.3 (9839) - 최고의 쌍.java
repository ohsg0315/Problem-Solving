import java.util.*;

public class Solution {
    private static boolean bestPair(String s) {
        int len = s.length();
        // 각 자리 수 가 1씩 커지지 않으면 false
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) + 1 != s.charAt(i + 1)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt(), res = -1;
            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            // 모든 경우의 수 순회
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (bestPair(Integer.toString(arr[i] * arr[j]))) {
                        res = Math.max(res, arr[i] * arr[j]);
                    }
                }
            }
            System.out.println("#" + testCase + " " + res);

        }
    }
}