import java.util.*;
import java.io.*;

public class Main {
    private static int N, M;
    private static int[] parent;
    private static ArrayList<Edge> edges;

    private static class Edge {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    private static int findParent(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = findParent(parent[a]);
    }

    private static void mergeParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    private static boolean isMerge(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a == b) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }
        edges = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(tokenizer.nextToken());
            int to = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken());
            edges.add(new Edge(from, to, weight));
        }
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        int sum = 0, cnt = 0;
        for (int i = 0; ; i++) {
            if (cnt == N - 1) {
                break;
            }
            Edge edge = edges.get(i);
            if (!isMerge(edge.from, edge.to)) {
                mergeParent(edge.from, edge.to);
                sum += edge.weight;
                cnt++;
            }
        }
        System.out.println(sum);
    } // end of main
} // end of class