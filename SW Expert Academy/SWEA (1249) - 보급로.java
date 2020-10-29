import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

class Solution {
    private static int N;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int[][] map, dist;

    private static class Node {
        int r, c, weight;

        public Node(int r, int c, int weight) {
            this.r = r;
            this.c = c;
            this.weight = weight;
        }
    }

    private static boolean isRange(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.weight - o2.weight;
            }
        });

        pq.offer(new Node(0, 0, 0));
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.weight > dist[now.r][now.c]) continue;

            for (int i = 0; i < 4; i++) {
                int nextR = now.r + dr[i];
                int nextC = now.c + dc[i];

                if (!isRange(nextR, nextC)) continue;

                if (dist[now.r][now.c] + map[nextR][nextC] < dist[nextR][nextC]) {
                    dist[nextR][nextC] = dist[now.r][now.c] + map[nextR][nextC];
                    pq.offer(new Node(nextR, nextC, dist[nextR][nextC]));
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            dist = new int[N][N];

            for (int i = 0; i < N; i++) {
                String s = br.readLine();

                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(s.charAt(j) + "");
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
            dijkstra();
            System.out.println("#" + testCase + " " + dist[N - 1][N - 1]);
        } // end of testCase
    } // end of main
} // end of class
