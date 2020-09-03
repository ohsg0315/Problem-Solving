import java.util.*;
import java.io.*;

public class Solution {
    private static int n, cnt;
    private static int[] parent;
    private static ArrayList<Edge> edges;

    private static class Point {
        int x, y;
    }

    private static class Edge implements Comparable<Edge> {
        int from, to;
        long dist;

        public Edge(int from, int to, long dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.dist, o.dist);
        }
    }

    private static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return false;

        if (a < b) parent[b] = a;
        else parent[a] = b;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            cnt = 0;
            n = Integer.parseInt(br.readLine());
            parent = new int[n];
            Point[] island = new Point[n];
            edges = new ArrayList<>();

            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                island[i] = new Point();
                island[i].x = Integer.parseInt(tokenizer.nextToken());
            }
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                island[i].y = Integer.parseInt(tokenizer.nextToken());
            }
            double e = Double.parseDouble(br.readLine());
            for (int i = 0; i < n - 1; i++) {
                for (int j = i; j < n; j++) {
                    if (i == j) continue;

                    long dist = (long) (Math.pow(island[i].x - island[j].x, 2) + Math.pow(island[i].y - island[j].y, 2));
                    edges.add(new Edge(i, j, dist));
                }
            }
            Collections.sort(edges);

            long sum = 0;
            for (Edge edge : edges) {
                if (cnt == n - 1) break;

                if (!union(edge.from, edge.to)) continue;

                cnt++;
                sum += edge.dist;
            }
            sum = Math.round(sum * e);
            System.out.println("#" + testCase + " " + sum);
        } // end of testCase
    } // end of main
} // end of class