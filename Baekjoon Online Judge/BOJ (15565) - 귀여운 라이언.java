import java.util.*;
import java.io.*;

public class Main {
    private static int n, k;
    private static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        k = Integer.parseInt(tokenizer.nextToken());
        list = new int[n];
        Deque<Integer> dq = new ArrayDeque<>();

        tokenizer = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int idx = 0, res = Integer.MAX_VALUE;
        while (idx < n) {
            if (list[idx] == 1) {
                dq.offer(idx);

                if (dq.size() == k + 1) {
                    dq.pollFirst();
                    int range = dq.peekLast() - dq.peekFirst() + 1;
                    if (res > range) res = range;
                }
            }
            idx++;
        }
        if (res == Integer.MAX_VALUE) res = -1;
        System.out.println(res);
    } // end of main
} // end of class