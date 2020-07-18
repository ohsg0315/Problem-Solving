import java.util.*;
import java.io.*;

public class Solution {
    private static int N, K, res = 0;

    private static void sol(int[] numArr, int total, int idx) {
        if (total > K) {
            return;
        }
        if (idx == N) {
            if (total == K) {
                res++;
            }
            return;
        }
        sol(numArr, total + numArr[idx], idx + 1);
        sol(numArr, total, idx + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            res = 0;
            N = Integer.parseInt(tokenizer.nextToken());
            K = Integer.parseInt(tokenizer.nextToken());
            int[] numArr = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

            sol(numArr, 0, 0);
            System.out.println("#" + testCase + " " + res);
        }
    }
}