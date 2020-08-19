import java.util.*;
import java.io.*;

public class Main {
    private static int res, maxDist = 0, cnt = 0;
    private static int[] dist;
    private static boolean[] visited;
    private static ArrayList<Integer>[] edegs;

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
        pq.offer(new Vertex(start, dist[start]));

        while (!pq.isEmpty()) {
            int now = pq.peek().index;
            int d = pq.poll().dist;

            if (d > dist[now]) continue;

            for (int i = 0, size = edegs[now].size(); i < size; i++) {
                int next = edegs[now].get(i);

                if (dist[next] > dist[now] + 1) {
                    dist[next] = dist[now] + 1;
                    if (dist[next] > maxDist) {
                        maxDist = dist[next];
                    }
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

        dist = new int[n + 1];
        edegs = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
            edegs[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());

            edegs[a].add(b);
            edegs[b].add(a);
        }
        dijkstra(1);

        boolean flag = true;
        for (int i = 1; i < n + 1; i++) {
            if (dist[i] == maxDist) {
                cnt++;
                if (flag) {
                    res = i;
                    flag = false;
                }
            }
        }
        System.out.println(res + " " + maxDist + " " + cnt);
    } // end of main
} // end of class