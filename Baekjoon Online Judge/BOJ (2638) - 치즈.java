import java.util.*;
import java.io.*;

public class Main {
    private static int n, m, cheese, res;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static int[][] map;
    private static boolean[][] visited;

    private static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

    private static void bfs() {
        Queue<int[]> qu = new LinkedList<>();
        visited = new boolean[n][m];

        qu.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!qu.isEmpty()) {
            int[] now = qu.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];

                if (!isRange(nextX, nextY)) continue;

                if (map[nextY][nextX] > 0) map[nextY][nextX]++;

                if (map[nextY][nextX] == 0 && !visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;
                    qu.offer(new int[]{nextX, nextY});
                }
            }
        }
    }

    private static int meltingCheese() {
        int total = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 2) {
                    map[i][j] = 0;
                    total++;
                } else if (map[i][j] == 2) map[i][j] = 1;
            }
        }
        return total;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());

                if (map[i][j] == 1) cheese++;
            }
        }
        while (cheese > 0) {
            bfs();
            cheese -= meltingCheese();
            res++;
        }
        System.out.println(res);
    }
}