import java.util.*;
import java.io.*;

public class Main {
    private static int N, M, res;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static int[][] map;
    private static boolean[][][] visited;

    private static class Point {
        int x, y, cnt, dist;

        public Point(int x, int y, int cnt, int dist) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.dist = dist;
        }
    }

    // 맵 범위를 벗어나는지 체크하는 함수
    private static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < M && y < N;
    }

    private static void bfs() {
        Queue<Point> qu = new LinkedList<>();

        visited[0][0][0] = true;
        qu.offer(new Point(0, 0, 0, 1));

        while (!qu.isEmpty()) {
            Point p = qu.poll();

            if (p.x == M - 1 && p.y == N - 1) {
                if (p.dist < res) res = p.dist;
                break;
            }

            // 상하좌우에 대하여 탐색
            for (int i = 0; i < 4; i++) {
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];

                // 범위를 벗어나면 continue
                if (!isRange(nextX, nextY)) continue;

                // 벽이 아닌곳
                if (map[nextY][nextX] == 0 && !visited[p.cnt][nextY][nextX]) {
                    visited[p.cnt][nextY][nextX] = true;
                    qu.offer(new Point(nextX, nextY, p.cnt, p.dist + 1));
                }
                // 벽 부수고 이동
                if (map[nextY][nextX] == 1 && p.cnt + 1 < 2 && !visited[p.cnt + 1][nextY][nextX]) {
                    visited[p.cnt + 1][nextY][nextX] = true;
                    qu.offer(new Point(nextX, nextY, p.cnt + 1, p.dist + 1));
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        // N, M 과 map 정보 입력
        res = Integer.MAX_VALUE;
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        map = new int[N][M];
        visited = new boolean[2][N][M];

        for (int i = 0; i < N; i++) {
            String buf = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(buf.charAt(j) + "");
            }
        }

        bfs();
        if (res == Integer.MAX_VALUE) res = -1;
        System.out.println(res);
    } // end of main
} // end of class