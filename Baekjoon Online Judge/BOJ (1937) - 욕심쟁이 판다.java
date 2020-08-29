import java.util.*;
import java.io.*;

public class Main {
    private static int n, res;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static int[][] map, cache;

    private static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }

    private static int dfs(int x, int y) {
        if (cache[y][x] != 0) return cache[y][x];

        int buf = 1;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (!isRange(nextX, nextY)) continue;
            if (map[y][x] < map[nextY][nextX]) {
                buf = Math.max(buf, dfs(nextX, nextY) + 1);
            }
        }
        return cache[y][x] = buf;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        cache = new int[n][n];

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cache[i][j] == 0) {
                    res = Math.max(res, dfs(j, i));
                }
            }
        }
        System.out.println(res);
    } // end of main
} // end of class