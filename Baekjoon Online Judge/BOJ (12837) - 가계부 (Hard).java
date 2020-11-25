import javax.lang.model.type.PrimitiveType;
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
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(tokenizer.nextToken()) + 1;
        int Q = Integer.parseInt(tokenizer.nextToken());

        arr = new long[N];
        tree = new long[N * 4];
        init(0, N - 1, 1);
        for (int i = 0; i < Q; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");

            char type = tokenizer.nextToken().charAt(0);
            // update
            if (type == '1') {
                int p = Integer.parseInt(tokenizer.nextToken());
                int x = Integer.parseInt(tokenizer.nextToken());

                arr[p] += x;
                update(0, N - 1, 1, p, x);
            }
            // print
            else if (type == '2') {
                int p = Integer.parseInt(tokenizer.nextToken());
                int q = Integer.parseInt(tokenizer.nextToken());

                sb.append(sum(0, N - 1, 1, p, q)).append('\n');
            }
        } // end of for

        System.out.print(sb.toString());
    } // end of main
}