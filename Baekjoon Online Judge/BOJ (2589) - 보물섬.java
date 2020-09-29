import java.util.*;
import java.io.*;

public class Main {
    private static int h, w;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static char[][] map;
    private static boolean[][] visited;

    private static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < w && y < h;
    }

    private static int bfs(int x, int y) {
        int dist = 0;
        Queue<int[]> qu = new LinkedList<>();
        visited = new boolean[h][w];

        qu.offer(new int[]{x, y, 0});
        visited[y][x] = true;

        while (!qu.isEmpty()) {
            int[] now = qu.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];

                if (!isRange(nextX, nextY)) continue;

                if (map[nextY][nextX] == 'L' && !visited[nextY][nextX]) {
                    qu.offer(new int[]{nextX, nextY, now[2] + 1});
                    visited[nextY][nextX] = true;

                    if (now[2] + 1 > dist) dist = now[2] + 1;
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " "); // 입력 받기 위한 토크나이저
        h = Integer.parseInt(tokenizer.nextToken());
        w = Integer.parseInt(tokenizer.nextToken());
        map = new char[h][w];

        for (int i = 0; i < h; i++) {
            String s = br.readLine();
            for (int j = 0; j < w; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int res = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 'W') continue;

                int buf = bfs(j, i);
                if (buf > res) res = buf;
            }
        }
        System.out.println(res);
    }
}