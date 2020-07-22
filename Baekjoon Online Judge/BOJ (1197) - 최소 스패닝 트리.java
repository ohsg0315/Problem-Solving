import java.util.*;
import java.io.*;

public class Main {
    private static int[] parent;

    private static class Edge {
        int from, to, weight;

        Edge(int from, int to, int weight) {
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

        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

    private static boolean isMerged(int a, int b) {
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
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(tokenizer.nextToken()), E = Integer.parseInt(tokenizer.nextToken());
        ArrayList<Edge> edges = new ArrayList<>();
        parent = new int[V + 1];

        for (int i = 0; i < V + 1; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < E; i++) {
            int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            edges.add(new Edge(edge[0], edge[1], edge[2]));
        }
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
        int res = 0, cnt = 0;
        Iterator<Edge> it = edges.iterator();

        while (cnt != V - 1) {
            Edge edge = it.next();
            if (isMerged(edge.from, edge.to)) {
                continue;
            }
            cnt++;
            res += edge.weight;
            mergeParent(edge.from, edge.to);
        }

        System.out.println(res);
    } // end of main
} // end of class