import java.util.*;

public class Solution {
    private static long findMaxSum(long[] a, long[] b, int K){
        long maxSum = Long.MIN_VALUE;

        for (int cnt = 0; cnt <= K; cnt++) {
            long bufSum = 0;

            for (int i = 0; i < a.length; i++) {
                bufSum += (a[i] * b[i + cnt]);
            }
            maxSum = Math.max(maxSum, bufSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;

        T = sc.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt(), M = sc.nextInt();
            long res;
            long[] a = new long[N], b = new long[M];

            for (int i = 0; i < N; i++) {
                a[i] = sc.nextLong();
            }
            for (int i = 0; i < M; i++) {
                b[i]=sc.nextLong();
            }

            if(N > M){
                res = findMaxSum(b, a, Math.abs(N-M));
            }else{
                res = findMaxSum(a, b, Math.abs(N-M));
            }
            System.out.println("#" + testCase + " " + res);
        }
    }
}