import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        long m = Long.parseLong(tokenizer.nextToken());
        long low = 0, high = Long.MIN_VALUE;
        long[] trees = new long[n];

        tokenizer = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            trees[i] = Long.parseLong(tokenizer.nextToken());
        }

        while (low <= high) {
            long mid = (low + high) / 2;
            long total = 0;

            for (long tree : trees) {
                total += (tree - mid) > 0 ? (tree - mid) : 0;

                if (total > m)
                    break;
            }
            if (total == m) {
                high = mid;
                break;
            } else if (total > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(high);
    } // end of main
} // end of class