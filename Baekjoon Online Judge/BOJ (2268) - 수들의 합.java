import java.io.*;
import java.util.*;

public class Main {
    private static long[] arr, tree;

    private static long init(int start, int end, int node) {
        if (start == end) return tree[node] = arr[start];

        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    private static long sum(int start, int end, int node, int left, int right) {
        if (right < start || end < left) return 0;

        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }

    private static void update(int start, int end, int node, int idx, long diff) {
        if (idx < start || end < idx) return;

        tree[node] += diff;
        if (start == end) return;

        int mid = (start + end) / 2;
        update(start, mid, node * 2, idx, diff);
        update(mid + 1, end, node * 2 + 1, idx, diff);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(tokenizer.nextToken()) + 1;
        int M = Integer.parseInt(tokenizer.nextToken());
        arr = new long[N];
        tree = new long[N * 4];
        StringBuilder sb = new StringBuilder();

        init(0, N - 1, 1);
        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            char type = tokenizer.nextToken().charAt(0);
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());

            // sum
            if (type == '0') {
                if (a < b)
                    sb.append(sum(0, N - 1, 1, a, b)).append('\n');
                else
                    sb.append(sum(0, N - 1, 1, b, a)).append('\n');
            }
            // modify
            else if (type == '1') {
                long diff = b - arr[a];
                arr[a] = b;
                update(0, N - 1, 1, a, diff);

            }
        }
        System.out.print(sb.toString());
    } // end of main
}