import java.util.*;
import java.io.*;

public class Main {
    private static int n, m, h, res;
    private static boolean[][] ladder;

    private static boolean isRight() {
        for (int i = 0; i < n; i++) {
            int x = i;
            for (int y = 0; y < h; y++) {
                if (ladder[y][x]) {
                    x++;
                } else if (x > 0 && ladder[y][x - 1]) x--;
            }
            if (x != i) return false;
        }
        return true;
    }

    private static void dfs(int x, int y, int cnt) {
        if (cnt == 4) return;
        if (cnt < 4) {
            if (isRight()) {
                if (cnt < res)
                    res = cnt;
                return;
            }
        }
        for (int i = y; i < h; i++, x = 0) {
            for (int j = x; j < n; j++) {
                if (j == n - 1 || (j > 1 && ladder[i][j - 1]) || ladder[i][j] || (j + 1 < n && ladder[i][j + 1])) {
                    continue;
                }
                ladder[i][j] = true;
                dfs(j + 2, i, cnt + 1);
                ladder[i][j] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        h = Integer.parseInt(tokenizer.nextToken());
        ladder = new boolean[h][n];

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(tokenizer.nextToken()) - 1;
            int b = Integer.parseInt(tokenizer.nextToken()) - 1;

            ladder[a][b] = true;
        }
        res = Integer.MAX_VALUE;
        dfs(0, 0, 0);
        if (res == Integer.MAX_VALUE) res = -1;
        System.out.println(res);
    } // end of main
} // end of class