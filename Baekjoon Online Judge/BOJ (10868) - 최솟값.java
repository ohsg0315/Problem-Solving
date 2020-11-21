import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static long[] list, tree;

    private static long init(int start, int end, int node) {
        if (start == end) return tree[node] = list[start];

        int mid = (start + end) / 2;
        return tree[node] = Math.min(init(start, mid, node * 2), init(mid + 1, end, node * 2 + 1));
    }

    private static long query(int start, int end, int node, int left, int right) {
        if (left > end || right < start) return Long.MAX_VALUE;

        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return Math.min(query(start, mid, node * 2, left, right), query(mid + 1, end, node * 2 + 1, left, right));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        list = new long[N];
        tree = new long[N * 4];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        init(0, N - 1, 1);
        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(br.readLine());

            int left = Integer.parseInt(tokenizer.nextToken()) - 1;
            int right = Integer.parseInt(tokenizer.nextToken()) - 1;

            sb.append(query(0, N - 1, 1, left, right)).append('\n');
        }
        System.out.print(sb.toString());
    }
}