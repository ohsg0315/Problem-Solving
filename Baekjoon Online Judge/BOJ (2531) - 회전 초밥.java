import java.util.*;
import java.io.*;

public class Main {
    private static int n, d, k, c, res;
    private static int[] list;
    private static int[] variety;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        int low = 0, high = 0, total = 0;
        n = Integer.parseInt(tokenizer.nextToken());
        d = Integer.parseInt(tokenizer.nextToken());
        k = Integer.parseInt(tokenizer.nextToken());
        c = Integer.parseInt(tokenizer.nextToken());

        list = new int[n + k];
        variety = new int[d + 1];

        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        for (int i = n; i < n + k - 1; i++) {
            list[i] = list[i - n];
        }

        // 처음
        for (high = 0; high < k; high++) {
            int now = list[high];
            if (variety[now] == 0) {
                total++;
            }
            variety[now]++;
        }
        res = total;

        while (true) {
            if (list[high] == 0) break;

            int before = list[low++];
            int now = list[high++];
            if (--variety[before] == 0) {
                total--;
            }
            if (variety[now]++ == 0) {
                total++;
            }


            if (variety[c] == 0) {
                res = Math.max(res, total + 1);
            } else {
                res = Math.max(res, total);
            }
        }

        System.out.println(res);
    } // end of main
} // end of class