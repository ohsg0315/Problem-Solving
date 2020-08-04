import java.util.*;
import java.io.*;

public class Solution {
    private static int[] parent;

    private static int find(int a) {
        if (parent[a] != a) {
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        parent[a] = b;
    }

    private static boolean isUnion(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(tokenizer.nextToken());
            int m = Integer.parseInt(tokenizer.nextToken());

            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
            for (int i = 0; i < m; i++) {
                tokenizer = new StringTokenizer(br.readLine(), " ");
                int type = Integer.parseInt(tokenizer.nextToken());
                int a = Integer.parseInt(tokenizer.nextToken());
                int b = Integer.parseInt(tokenizer.nextToken());

                if (type == 0) {
                    union(a, b);
                } else if (type == 1) {
                    if (isUnion(a, b)) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                }
            }
            System.out.println("#" + testCase + " " + sb.toString());
        }
    }
}