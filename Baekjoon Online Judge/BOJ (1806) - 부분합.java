import java.util.*;
import java.io.*;

public class Main {
    private static int n, s;
    private static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(tokenizer.nextToken());
        s = Integer.parseInt(tokenizer.nextToken());
        list = new int[n];

        tokenizer = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int low = 0, high = 0, res = n;
        long sum = 0;
        boolean flag = true;
        while (true) {
            if (sum >= s) {
                flag = false;
                if (high - low < res) res = high - low;
                sum -= list[low++];
            } else if (sum < s) {
                if (high == n) break;
                sum += list[high++];
            }
        }
        if (flag) res = 0;
        System.out.println(res);
    } // end of main
} // end of class