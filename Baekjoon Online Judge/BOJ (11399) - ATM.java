import java.io.*;
import java.util.*;

public class Main {
    private static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), total = 0, wait = 0;
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        list = new int[n];

        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(list);
        for (int time : list) {
            total += time + wait;
            wait += time;
        }
        System.out.println(total);
    } // end of main
}