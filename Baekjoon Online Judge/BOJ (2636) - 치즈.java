import java.util.*;
import java.io.*;

public class Main {
    private static int w, h, cheese, res, buf;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static int[][] map;

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < w && y < h;
    }

    private static void bfs() {
        Queue<Point> qu = new LinkedList<>();
        boolean[][] visited = new boolean[h][w];

        qu.offer(new Point(0, 0));
        visited[0][0] = true;

        while (!qu.isEmpty()) {
            Point p = qu.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];

                if (!isRange(nextX, nextY)) continue;

                if (map[nextY][nextX] == 0 && !visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;
                    qu.offer(new Point(nextX, nextY));
                }
                if (map[nextY][nextX] == 1 && !visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;
                    map[nextY][nextX]++;
                }
            }
        }
    }

    private static int meltCheese() {
        int cnt = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 2) {
                    map[i][j] = 0;
                    cnt++;
                }
            }
        }
        return buf = cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        h = Integer.parseInt(tokenizer.nextToken());
        w = Integer.parseInt(tokenizer.nextToken());
        map = new int[h][w];
        for (int i = 0; i < h; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());

                if (map[i][j] == 1) cheese++;
            }
        }
        while (cheese > 0) {
            bfs();
            cheese -= meltCheese();
            res++;
        }
        System.out.println(res);
        System.out.println(buf);
    } // end of main
} // end of class