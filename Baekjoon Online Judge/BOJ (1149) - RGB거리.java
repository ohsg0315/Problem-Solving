import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int[][] home;
    private static int[][] cache;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        n = Integer.parseInt(br.readLine());
        home = new int[n][3];
        cache = new int[n][3];

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine());

            home[i][0] = Integer.parseInt(tokenizer.nextToken());
            home[i][1] = Integer.parseInt(tokenizer.nextToken());
            home[i][2] = Integer.parseInt(tokenizer.nextToken());
        }
        cache[0][0] = home[0][0];
        cache[0][1] = home[0][1];
        cache[0][2] = home[0][2];

        for (int i = 1; i < n; i++) {
            cache[i][0] = home[i][0] + Math.min(cache[i - 1][1], cache[i - 1][2]);
            cache[i][1] = home[i][1] + Math.min(cache[i - 1][0], cache[i - 1][2]);
            cache[i][2] = home[i][2] + Math.min(cache[i - 1][0], cache[i - 1][1]);
        }
        int res = Math.min(cache[n - 1][0], Math.min(cache[n - 1][1], cache[n - 1][2]));
        System.out.println(res);
    } // end of main
} // end of class