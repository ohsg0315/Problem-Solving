import java.util.*;
import java.io.*;

public class Solution {
    private static int n, res;
    private static int[] weight, order;
    private static boolean[] selected;

    private static void permutation(int cnt) {
        if (cnt == n) {
            dfs(0, 0, 0);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!selected[i]) {
                selected[i] = true;
                order[cnt] = i;
                permutation(cnt + 1);
                selected[i] = false;
            }
        }
    }

    private static void dfs(int lSum, int rSum, int cnt) {
        if (cnt == n) {
            res++;
            return;
        }
        int buf = weight[order[cnt]];
        dfs(lSum + buf, rSum, cnt + 1);

        if (lSum >= rSum + buf) {
            dfs(lSum, rSum + buf, cnt + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            res = 0;
            n = Integer.parseInt(br.readLine());
            weight = new int[n];
            order = new int[n];
            selected = new boolean[n];
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                weight[i] = Integer.parseInt(tokenizer.nextToken());
            }

            permutation(0);

            System.out.println("#" + testCase + " " + res);
        } // end of testCase
    } // end of main
} // end of class