import java.util.*;
import java.io.*;

public class Main {
    private static int n, m, res;
    private static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        list = new int[n];
        tokenizer = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(tokenizer.nextToken());
        }
        int l = 0, h = 0, sum = 0;
        while (true) {
            if (sum > m) {
                sum -= list[l++];
            } else if (h == n) {
                break;
            } else {
                sum += list[h++];
            }
            if (sum == m) res++;
        }
        System.out.println(res);
    } // end of main
} // end of class