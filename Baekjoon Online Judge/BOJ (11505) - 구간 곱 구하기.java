import java.io.*;
import java.util.*;

public class Main {
    private static final int MOD = 1_000_000_007;
    private static long[] arr, tree;

    private static long init(int start, int end, int node) {
        if (start == end) return tree[node] = arr[start];

        int mid = (start + end) / 2;
        return tree[node] = (init(start, mid, node * 2) * init(mid + 1, end, node * 2 + 1)) % MOD;
    }

    private static long multiple(int start, int end, int node, int left, int right) {
        if (right < start || end < left) return 1;

        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return (multiple(start, mid, node * 2, left, right) * multiple(mid + 1, end, node * 2 + 1, left, right)) % MOD;
    }

    private static long update(int start, int end, int node, int idx, long value) {
        if (idx < start || end < idx) return tree[node];

        if (start == end) return tree[node] = value;

        int mid = (start + end) / 2;
        return tree[node] = (update(start, mid, node * 2, idx, value) * update(mid + 1, end, node * 2 + 1, idx, value)) % MOD;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());
        arr = new long[n];
        tree = new long[n * 4];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        init(0, n - 1, 1);
        for (int i = 0, len = m + k; i < len; i++) {
            tokenizer = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken()) - 1;
            int c = Integer.parseInt(tokenizer.nextToken());

            if (a == 1) {
                update(0, n - 1, 1, b, c);
                arr[b] = c;
            } else if (a == 2) {
                c--;
                sb.append(multiple(0, n - 1, 1, b, c) % MOD).append('\n');
            }
        }
        System.out.print(sb.toString());
    } // end of main
}