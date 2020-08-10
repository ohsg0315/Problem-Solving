import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int[][] tri, cache;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        n = Integer.parseInt(br.readLine());
        tri = new int[n][n];
        cache = new int[n][n];

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                tri[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        cache[0][0] = tri[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int left = 0, right = 0;
                if (j > 0) {
                    left = cache[i - 1][j - 1];
                }
                if (j < i) {
                    right = cache[i - 1][j];
                }
                cache[i][j] = tri[i][j] + Math.max(left, right);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, cache[n - 1][i]);
        }
        System.out.println(res);
    } // end of main
} // end of class