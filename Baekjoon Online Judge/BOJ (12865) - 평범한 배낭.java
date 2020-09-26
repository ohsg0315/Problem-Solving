import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(tokenizer.nextToken());
        int w = Integer.parseInt(tokenizer.nextToken());
        int[][] cache = new int[n + 1][w + 1];

        for (int i = 1; i <= n; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            int curW = Integer.parseInt(tokenizer.nextToken());
            int v = Integer.parseInt(tokenizer.nextToken());

            for (int j = 0; j <= w; j++) {
                if (j >= curW) {
                    cache[i][j] = Math.max(v + cache[i - 1][j - curW], cache[i - 1][j]);
                } else {
                    cache[i][j] = cache[i - 1][j];
                }
            }
        }
        System.out.println(cache[n][w]);
    }
}