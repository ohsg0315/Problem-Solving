import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        int k = Integer.parseInt(tokenizer.nextToken());
        int n = Integer.parseInt(tokenizer.nextToken());
        int[] lines = new int[k];
        long low = 1, high = 1, res = 0;
        for (int i = 0; i < k; i++) {
            lines[i] = Integer.parseInt(br.readLine());

            if (lines[i] > high) {
                high = lines[i];
            }
        }

        while (low <= high) {
            long mid = (low + high) / 2;
            int cnt = 0;

            for (int i = 0; i < k; i++) {
                cnt += lines[i] / mid;
            }

            if (cnt >= n) {
                if (mid > res) {
                    res = mid;
                }
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        } // end of while
        System.out.println(res);
    } // end of main
} // end of class