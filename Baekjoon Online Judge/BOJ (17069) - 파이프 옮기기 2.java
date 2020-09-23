import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static int[][] dx = {{1, 1}, {0, 1}, {1, 1, 0}};
    private static int[][] dy = {{0, 1}, {1, 1}, {0, 1, 1}};
    private static int[][] home;
    private static long[][][] cache;

    private static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    private static long dfs(int x, int y, int cur) {
        if (x == N - 1 && y == N - 1) {
            return 1;
        }

        if (cache[y][x][cur] != 0) return cache[y][x][cur];

        long cnt = 0;
        for (int i = 0; i < dx[cur].length; i++) {
            int nextX = x + dx[cur][i];
            int nextY = y + dy[cur][i];

            if (!isRange(nextX, nextY) || home[nextY][nextX] == 1) {
                continue;
            }
            // 대각선의 경우
            if (i == 1) {
                if (home[nextY - 1][nextX] == 1 || home[nextY][nextX - 1] == 1) {
                    continue;
                }
            }
            int dir = cur;
            if (i == 1) {
                dir = 2;
            } else if (cur == 2) {
                if (i == 0) {
                    dir = 0;
                } else {
                    dir = 1;
                }
            }
            cnt += dfs(nextX, nextY, dir);
        }
        return cache[y][x][cur] = cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        N = Integer.parseInt(br.readLine());
        home = new int[N][N];
        cache = new long[N][N][3];

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                home[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        dfs(1, 0, 0);
        System.out.println(cache[0][1][0]);
    }
}
