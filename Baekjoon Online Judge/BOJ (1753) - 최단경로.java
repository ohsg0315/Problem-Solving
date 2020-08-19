import java.util.*;
import java.io.*;

public class Main {
    private static int[] dist;
    private static ArrayList<Vertex>[] edegs;

    private static class Vertex implements Comparable<Vertex> {
        int index, dist;

        public Vertex(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.dist - o.dist;
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Vertex(start, 0));

        while (!pq.isEmpty()) {
            int now = pq.peek().index;
            int d = pq.poll().dist;

            if (d > dist[now]) continue;

            for (int i = 0, size = edegs[now].size(); i < size; i++) {
                int next = edegs[now].get(i).index;
                int nextD = edegs[now].get(i).dist;

                if (dist[next] > dist[now] + nextD) {
                    dist[next] = dist[now] + nextD;
                    pq.offer(new Vertex(next, dist[next]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int start = Integer.parseInt(br.readLine());
        dist = new int[n + 1];
        edegs = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
            edegs[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(tokenizer.nextToken());
            int v = Integer.parseInt(tokenizer.nextToken());
            int w = Integer.parseInt(tokenizer.nextToken());

            edegs[u].add(new Vertex(v, w));
        }

        dijkstra(start);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF").append('\n');
            } else {
                sb.append(dist[i]).append('\n');
            }
        }
        System.out.print(sb.toString());
    } // end of main
} // end of class