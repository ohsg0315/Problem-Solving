import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    private static int n, res = 1;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static int[][] map;
    private static boolean[][] visited;

    private static boolean isRange(int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= n) {
            return false;
        }
        return true;
    }

    private static void bfs(int x, int y, int height) {
        Queue<Point> qu = new LinkedList<>();

        qu.offer(new Point(x, y));
        visited[y][x] = true;

        while (!qu.isEmpty()) {
            Point p = qu.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];

                if (!isRange(nextX, nextY)) {
                    continue;
                }
                if (map[nextY][nextX] > height && !visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;
                    qu.offer(new Point(nextX, nextY));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());

                if (low > map[i][j]) {
                    low = map[i][j];
                } else if (high < map[i][j]) {
                    high = map[i][j];
                }
            }
        }

        for (int height = low; height < high; height++) {
            int island = 0;
            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && map[i][j] > height) {
                        bfs(j, i, height);
                        island++;
                    }
                }
            }
            if (island > res) {
                res = island;
            }
        }

        System.out.println(res);
    } // end of main
} // end of class