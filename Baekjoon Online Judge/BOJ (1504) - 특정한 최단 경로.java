import java.util.*;
import java.io.*;

public class Main {
    private static long res;
    private static int[][] dist;
    private static boolean[] visited;
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

    private static void dijkstra(int start, int c) {
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        dist[c][start] = 0;
        pq.offer(new Vertex(start, dist[c][start]));

        while (!pq.isEmpty()) {
            int now = pq.peek().index;
            int d = pq.poll().dist;

            if (d > dist[c][now]) continue;

            for (int i = 0, size = edegs[now].size(); i < size; i++) {
                int next = edegs[now].get(i).index;
                int nextD = edegs[now].get(i).dist;

                if (dist[c][next] > dist[c][now] + nextD) {
                    dist[c][next] = dist[c][now] + nextD;
                    pq.offer(new Vertex(next, dist[c][next]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        dist = new int[3][n + 1];
        edegs = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < 3; j++) {
                dist[j][i] = Integer.MAX_VALUE;
            }
            edegs[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int c = Integer.parseInt(tokenizer.nextToken());

            edegs[a].add(new Vertex(b, c));
            edegs[b].add(new Vertex(a, c));
        }
        tokenizer = new StringTokenizer(br.readLine(), " ");
        int[] start = new int[3];
        start[0] = 1;
        start[1] = Integer.parseInt(tokenizer.nextToken());
        start[2] = Integer.parseInt(tokenizer.nextToken());

        for (int i = 0; i < 3; i++) {
            dijkstra(start[i], i);
        }

        if ((dist[0][start[1]] == Integer.MAX_VALUE && dist[0][start[2]] == Integer.MAX_VALUE) || (dist[1][start[2]] == Integer.MAX_VALUE) || (dist[1][n] == Integer.MAX_VALUE && dist[2][n] == Integer.MAX_VALUE)) {
            res = -1;
        } else {
            int buf = dist[0][start[1]] + dist[1][start[2]] + dist[2][n];
            res = dist[0][start[2]] + dist[2][start[1]] + dist[1][n];

            res = Math.min(res, buf);
        }
        System.out.println(res);
    } // end of main
} // end of class