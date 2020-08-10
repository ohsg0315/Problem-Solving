import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    private static int n, m;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static int[][] farm;
    private static boolean[][] visited;

    private static boolean isRange(int x, int y) {
        if (x < 0 || y < 0 || x >= m || y >= n) {
            return false;
        }
        return true;
    }

    private static void bfs(int x, int y) {
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

                if (farm[nextY][nextX] == 1 && !visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;
                    qu.offer(new Point(nextX, nextY));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(tokenizer.nextToken());
            n = Integer.parseInt(tokenizer.nextToken());
            int k = Integer.parseInt(tokenizer.nextToken()), res = 0;

            farm = new int[n][m];
            visited = new boolean[n][m];

            for (int i = 0; i < k; i++) {
                tokenizer = new StringTokenizer(br.readLine(), " ");

                int x = Integer.parseInt(tokenizer.nextToken());
                int y = Integer.parseInt(tokenizer.nextToken());

                farm[y][x] = 1;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (farm[i][j] == 1 && !visited[i][j]) {
                        bfs(j, i);
                        res++;
                    }
                }
            }
            System.out.println(res);
        } // end of testCase
    } // end of main
} // end of class