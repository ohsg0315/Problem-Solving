import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            String[] buffer = br.readLine().split(" ");
            int N = Integer.parseInt(buffer[0]), M = Integer.parseInt(buffer[1]), res = -1;
            int[] snackWeight = new int[N];

            buffer = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                snackWeight[i] = Integer.parseInt(buffer[i]);
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (snackWeight[i] + snackWeight[j] <= M) {
                        res = Math.max(res, snackWeight[i] + snackWeight[j]);
                    }
                }
            }
            System.out.println("#" + testCase + " " + res);
        }
    }
}