import java.util.*;
import java.io.*;

public class Main {
    private static int n, m, res;
    private static int[] parent;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static int[][] map;
    private static boolean[][] visited;
    private static PriorityQueue<Edge> pq;

    private static class Edge {
        int from;
        int to;
        int dist;

        public Edge(int from, int to, int length) {
            this.from = from;
            this.to = to;
            this.dist = length;
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

    private static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

    private static void findBridge() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {
                    for (int dir = 0; dir < 4; dir++) {
                        int nextX = j + dx[dir];
                        int nextY = i + dy[dir];
                        int dist = 0;
                        boolean flag = true;

                        while (true) {
                            if (!isRange(nextX, nextY) || map[i][j] == map[nextY][nextX]) {
                                flag = false;
                                break;
                            }
                            if (map[nextY][nextX] != 0) break;
                            dist++;
                            nextX += dx[dir];
                            nextY += dy[dir];
                        }
                        if (flag && dist > 1) {
                            pq.offer(new Edge(map[i][j], map[nextY][nextX], dist));
                        }
                    }
                }
            }
        }
    }

    private static void bfs(int x, int y, int cnt) {
        Queue<int[]> qu = new LinkedList<>();
        qu.offer(new int[]{x, y});
        visited[y][x] = true;
        map[y][x] = cnt;

        while (!qu.isEmpty()) {
            int curX = qu.peek()[0];
            int curY = qu.poll()[1];

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (!isRange(nextX, nextY)) continue;

                if (map[nextY][nextX] == 1 && !visited[nextY][nextX]) {
                    qu.offer(new int[]{nextX, nextY});
                    visited[nextY][nextX] = true;
                    map[nextY][nextX] = cnt;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.dist - o2.dist;
            }
        });

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    bfs(j, i, ++cnt);
                }
            }
        }
        parent = new int[cnt + 1];
        for (int i = 1; i <= cnt; i++) {
            parent[i] = i;
        }
        findBridge();

        int bridge = 0;
        while (!pq.isEmpty()) {
            Edge e = pq.poll();

            if (union(e.from, e.to)) {
                res += e.dist;
                bridge++;
            }
            if (bridge == cnt - 1) break;
        }
        if (bridge != cnt - 1) res = -1;
        System.out.println(res);
    } // end of main
} // end of class