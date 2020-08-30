import java.util.*;
import java.io.*;

public class Main {
    private static int n, m, res;
    private static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        list = new int[n];

        tokenizer = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(list);
        int lo = 0, high = n - 1;

        while (lo < high) {
            if (list[lo] + list[high] == m) {
                res++;
                lo++;
                high--;
            } else if (list[lo] + list[high] < m) {
                lo++;
            } else {
                high--;
            }
        }
        System.out.println(res);
    } // end of main
} // end of class