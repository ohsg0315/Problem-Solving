import java.util.*;
import java.io.*;

public class Main {
    private static int R, C, res = 0;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static char[][] board;
    private static boolean[] visited;

    private static boolean isRange(int x, int y) {
        if (x < 0 || y < 0 || x >= C || y >= R) {
            return false;
        }
        return true;
    }

    private static void dfs(int x, int y, int cnt) {
        res = Math.max(res, cnt);

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (!isRange(nextX, nextY) || visited[board[nextY][nextX]]) {
                continue;
            }

            visited[board[nextY][nextX]] = true;
            dfs(nextX, nextY, cnt + 1);

            visited[board[nextY][nextX]] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(tokenizer.nextToken());
        C = Integer.parseInt(tokenizer.nextToken());
        board = new char[R][C];
        visited = new boolean['Z' + 1];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        visited[board[0][0]] = true;
        dfs(0, 0, 1);
        System.out.println(res);
    } // end of main
} // end of class