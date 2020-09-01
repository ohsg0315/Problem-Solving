import java.util.*;
import java.io.*;

public class Main {
    private static int n, m;
    private static int[] dist;
    private static ArrayList<Vertex>[] list;

    private static class Vertex implements Comparable {
        int index, dist;

        public Vertex(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }


        @Override
        public int compareTo(Object o) {
            Vertex v = (Vertex) o;
            return this.dist - v.dist;
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

            for (int i = 0, size = list[now].size(); i < size; i++) {
                int next = list[now].get(i).index;
                int nextD = list[now].get(i).dist;

                if (dist[next] > dist[now] + nextD) {
                    dist[next] = dist[now] + nextD;
                    pq.offer(new Vertex(next, dist[next]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dist = new int[n + 1];
        list = new ArrayList[n + 1];

        for (int i = 1; i < n + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(tokenizer.nextToken());
            int to = Integer.parseInt(tokenizer.nextToken());
            int dist = Integer.parseInt(tokenizer.nextToken());

            list[from].add(new Vertex(to, dist));
        }
        tokenizer = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(tokenizer.nextToken());
        int end = Integer.parseInt(tokenizer.nextToken());

        dijkstra(start);
        System.out.println(dist[end]);
    } // end of main
} // end of class