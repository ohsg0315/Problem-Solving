import java.util.*;
import java.io.*;

public class Main {
    private static int n, level = 2, eat, res, x, y;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static int[][] map;
    private static boolean[][] visited;
    private static PriorityQueue<Point> pq;

    private static class Point {
        int x, y, dist;

        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    private static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }

    private static boolean bfs(int x, int y) {
        Queue<Point> qu = new LinkedList<>();

        visited = new boolean[n][n];
        pq.clear();

        qu.offer(new Point(x, y, 0));
        visited[y][x] = true;

        while (!qu.isEmpty()) {
            Point p = qu.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];

                if (!isRange(nextX, nextY)) continue;

                if (!visited[nextY][nextX] && map[nextY][nextX] <= level) {
                    qu.offer(new Point(nextX, nextY, p.dist + 1));
                    visited[nextY][nextX] = true;
                    if (map[nextY][nextX] != 0 && map[nextY][nextX] < level) {
                        if (!pq.isEmpty() && pq.peek().dist < p.dist + 1) return true;
                        pq.offer(new Point(nextX, nextY, p.dist + 1));
                    }
                }
            }
        }
        if (pq.isEmpty()) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        pq = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.dist == o2.dist) {
                    if (o1.y == o2.y) {
                        return o1.x - o2.x;
                    }
                    return o1.y - o2.y;
                }
                return o1.dist - o2.dist;
            }
        });

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());

                if (map[i][j] == 9) {
                    x = j;
                    y = i;
                    map[i][j] = 0;
                }
            }
        }
        while (true) {
            if (!bfs(x, y)) break;

            eat++;
            Point next = pq.poll();

            if (eat == level) {
                eat = 0;
                level++;
            }
            res += next.dist;
            x = next.x;
            y = next.y;
            map[y][x] = 0;
        }
        System.out.println(res);
    } // end of main
} // end of class