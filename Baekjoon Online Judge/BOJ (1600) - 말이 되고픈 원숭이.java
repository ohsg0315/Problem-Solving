import java.util.*;
import java.io.*;

public class Main {
    private static int w, h, k, res;
    private static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1, -2, -2, 2, 2};
    private static int[] dy = {-1, 1, 0, 0, -2, -2, 2, 2, -1, 1, -1, 1};
    private static int[][] map;
    private static boolean[][][] visited;

    private static class Point {
        int x, y, k, cnt;

        public Point(int x, int y, int k, int cnt) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.cnt = cnt;
        }
    }

    private static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < w && y < h;
    }

    private static void bfs() {
        Queue<Point> qu = new LinkedList<>();
        qu.offer(new Point(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!qu.isEmpty()) {
            Point p = qu.poll();

            if (p.x == w - 1 && p.y == h - 1) {
                if (p.cnt < res) res = p.cnt;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];

                if (!isRange(nextX, nextY)) continue;

                if (map[nextY][nextX] == 0 && !visited[p.k][nextY][nextX]) {
                    visited[p.k][nextY][nextX] = true;
                    qu.offer(new Point(nextX, nextY, p.k, p.cnt + 1));
                }
            }
            if (p.k < k) {
                for (int i = 4; i < 12; i++) {
                    int nextX = p.x + dx[i];
                    int nextY = p.y + dy[i];

                    if (!isRange(nextX, nextY)) continue;

                    if (map[nextY][nextX] == 0 && !visited[p.k + 1][nextY][nextX]) {
                        visited[p.k + 1][nextY][nextX] = true;
                        qu.offer(new Point(nextX, nextY, p.k + 1, p.cnt + 1));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        res = Integer.MAX_VALUE;
        w = Integer.parseInt(tokenizer.nextToken());
        h = Integer.parseInt(tokenizer.nextToken());
        map = new int[h][w];
        visited = new boolean[k + 1][h][w];

        for (int i = 0; i < h; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        bfs();
        if (res == Integer.MAX_VALUE) res = -1;
        System.out.println(res);
    } // end of main
} // end of class