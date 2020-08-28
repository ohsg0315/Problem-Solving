import java.util.*;
import java.io.*;

public class Solution {
    private static int n, res;
    private static int[][] synergy;
    private static boolean[] selected;

    private static void combination(int idx, int cnt) {
        if (cnt == n / 2) {
            int size = n / 2;
            int aRes = 0, bRes = 0;
            ArrayList<Integer> a = new ArrayList<>(), b = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (selected[i]) {
                    a.add(i);
                } else {
                    b.add(i);
                }
            }
            for (int i = 0; i < size; i++) {
                int aBuf = a.get(i);
                int bBuf = b.get(i);

                for (int j = 0; j < size; j++) {
                    if (i == j) continue;
                    aRes += synergy[aBuf][a.get(j)];
                    bRes += synergy[bBuf][b.get(j)];
                }
            }
            int cur = Math.abs(aRes - bRes);
            if (cur < res) res = cur;
            return;
        }
        for (int i = idx; i < n; i++) {
            selected[i] = true;
            combination(i + 1, cnt + 1);
            selected[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            n = Integer.parseInt(br.readLine());
            res = Integer.MAX_VALUE;
            synergy = new int[n][n];
            selected = new boolean[n];
            for (int i = 0; i < n; i++) {
                tokenizer = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    synergy[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }
            combination(0, 0);
            System.out.println("#" + testCase + " " + res);
        } // end of testCase
    } // end of main
} // end of class