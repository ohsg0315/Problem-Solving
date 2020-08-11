import java.util.*;
import java.io.*;

public class Main {
    private static int[] coin, cache;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(tokenizer.nextToken());
        int target = Integer.parseInt(tokenizer.nextToken());

        coin = new int[n];
        cache = new int[target + 1];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        cache[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= target; j++) {
                cache[j] += cache[j - coin[i]];
            }
        }
        System.out.println(cache[target]);
    } // end of main
} // end of class