import java.io.*;
import java.util.*;

public class Main {
    private static int[] arr, minTree, maxTree;

    private static int minInit(int start, int end, int node) {
        if (start == end) return minTree[node] = arr[start];

        int mid = (start + end) / 2;
        return minTree[node] = Math.min(minInit(start, mid, node * 2), minInit(mid + 1, end, node * 2 + 1));
    }

    private static int minQuery(int start, int end, int node, int left, int right) {
        if (right < start || end < left) return Integer.MAX_VALUE;

        if (left <= start && end <= right) return minTree[node];

        int mid = (start + end) / 2;
        return Math.min(minQuery(start, mid, node * 2, left, right), minQuery(mid + 1, end, node * 2 + 1, left, right));
    }

    private static int maxInit(int start, int end, int node) {
        if (start == end) return maxTree[node] = arr[start];

        int mid = (start + end) / 2;
        return maxTree[node] = Math.max(maxInit(start, mid, node * 2), maxInit(mid + 1, end, node * 2 + 1));
    }

    private static int maxQuery(int start, int end, int node, int left, int right) {
        if (right < start || end < left) return -1;

        if (left <= start && end <= right) return maxTree[node];

        int mid = (start + end) / 2;
        return Math.max(maxQuery(start, mid, node * 2, left, right), maxQuery(mid + 1, end, node * 2 + 1, left, right));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        arr = new int[n];
        minTree = new int[n * 4];
        maxTree = new int[n * 4];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        minInit(0, n - 1, 1);
        maxInit(0, n - 1, 1);
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            int left = Integer.parseInt(tokenizer.nextToken()) - 1;
            int right = Integer.parseInt(tokenizer.nextToken()) - 1;
            int minNum = minQuery(0, n - 1, 1, left, right);
            int maxNum = maxQuery(0, n - 1, 1, left, right);

            sb.append(minNum).append(' ').append(maxNum).append('\n');
        }
        System.out.print(sb.toString());
    } // end of main
}