import java.util.*;
import java.io.*;

public class Main {
    private static class Point {
        int x, y, cnt;

        Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    private static int N, M, res;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int[][] maze;
    private static boolean flag = false;
    private static boolean[][] visited;

    private static boolean isRange(int x, int y) {
        if (x < 0 || y < 0 || x >= M || y >= N) {
            return false;
        }
        return true;
    }

    private static void BFS() {
        Queue<Point> qu = new LinkedList<>();

        visited[0][0] = true;
        qu.offer(new Point(0, 0, 1));

        while (!qu.isEmpty()) {
            Point now = qu.poll();

            if (now.x == M - 1 && now.y == N - 1) {
                res = now.cnt;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if (isRange(nextX, nextY) && maze[nextY][nextX] == 1 && !visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;
                    qu.offer(new Point(nextX, nextY, now.cnt + 1));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        maze = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            maze[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        BFS();
        System.out.println(res);
    } // end of main
} // end of class