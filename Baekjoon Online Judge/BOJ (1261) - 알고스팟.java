import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
    private static int N, M;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static int[][] map, dist;
    private static boolean[][] visited;

    // 맵 범위를 벗어나는지 체크하는 함수
    private static boolean isRange(int x, int y) {
        if (x < 0 || y < 0 || x >= M || y >= N) {
            return false;
        }
        return true;
    }

    private static void bfs() {
        Deque<Point> dq = new ArrayDeque<>();

        visited[0][0] = true;
        dq.offer(new Point(0, 0));

        while (!dq.isEmpty()) {
            Point p = dq.poll();

            // 상하좌우에 대하여 탐색
            for (int i = 0; i < 4; i++) {
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];

                // map 범위를 벗어나면 deque에 넣지 않는다
                if (!isRange(nextX, nextY)) {
                    continue;
                }

                // 방문하지 않았다면 덱에 넣는다.
                if (!visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;

                    // 벽이면 뚫고 뒤에 넣음
                    if (map[nextY][nextX] == 1) {
                        dist[nextY][nextX] = dist[p.y][p.x] + 1;
                        dq.offerLast(new Point(nextX, nextY));
                    } else {
                        dist[nextY][nextX] = dist[p.y][p.x];
                        dq.offerFirst(new Point(nextX, nextY));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        // N, M 과 map 정보 입력
        M = Integer.parseInt(tokenizer.nextToken());
        N = Integer.parseInt(tokenizer.nextToken());
        map = new int[N][M];
        dist = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String buf = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(buf.charAt(j) + "");
            }
        }

        bfs();
        System.out.println(dist[N - 1][M - 1]);
    } // end of main
} // end of class