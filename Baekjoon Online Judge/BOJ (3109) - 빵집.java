import java.util.*;
import java.io.*;

public class Main {
    private static int r, c, res;
    private static boolean flag;
    private static int[] dx = {1, 1, 1};
    private static int[] dy = {-1, 0, 1};
    private static char[][] map;
    private static boolean[][] visited;

    private static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < c && y < r;
    }

    private static void backtracking(int x, int y) {
        if (x == c - 1) {
            res++;
            flag = true;
            return;
        }
        for (int i = 0; i < 3; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (!isRange(nextX, nextY)) continue;

            if (map[nextY][nextX] == '.' && !visited[nextY][nextX]) {
                visited[nextY][nextX] = true;
                backtracking(nextX, nextY);
                if (flag) return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(tokenizer.nextToken());
        c = Integer.parseInt(tokenizer.nextToken());
        map = new char[r][c];
        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String buf = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = buf.charAt(j);
            }
        }
        for (int i = 0; i < r; i++) {
            flag = false;
            backtracking(0, i);
        }
        System.out.println(res);
    } // end of main
} // end of class