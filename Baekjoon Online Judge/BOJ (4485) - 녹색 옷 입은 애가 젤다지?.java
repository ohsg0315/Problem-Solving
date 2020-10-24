import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int[][] map, dist;

    private static class Node {
        int r, c, cost;

        public Node(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
    }

    private static boolean isRange(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });

        pq.offer(new Node(0, 0, map[0][0]));
        dist[0][0] = map[0][0];

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.cost > dist[now.r][now.c]) continue;

            for (int i = 0; i < 4; i++) {
                int nextR = now.r + dr[i];
                int nextC = now.c + dc[i];

                if (!isRange(nextR, nextC)) continue;

                if (dist[nextR][nextC] > dist[now.r][now.c] + map[nextR][nextC]) {
                    dist[nextR][nextC] = dist[now.r][now.c] + map[nextR][nextC];
                    pq.offer(new Node(nextR, nextC, dist[nextR][nextC]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        int testCase = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());

            if (N == 0) break;

            map = new int[N][N];
            dist = new int[N][N];

            for (int i = 0; i < N; i++) {
                tokenizer = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(tokenizer.nextToken());
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
            dijkstra();
            System.out.println("Problem " + testCase++ + ": " + dist[N - 1][N - 1]);
        } // end of while
    } // end of main
} // end of class