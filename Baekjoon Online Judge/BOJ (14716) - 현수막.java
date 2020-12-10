import java.io.*;
import java.util.*;

public class Main {
    private static int m, n, res;
    private static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    private static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
    private static int[][] board;
    protected static boolean[][] visited;

    private static boolean isRange(int r, int c) {
        return r >= 0 && c >= 0 && r < m && c < n;
    }

    private static void bfs(int r, int c) {
        Queue<int[]> qu = new LinkedList<>();
        visited[r][c] = true;
        qu.offer(new int[]{r, c});

        while (!qu.isEmpty()) {
            int[] now = qu.poll();

            for (int i = 0; i < 8; i++) {
                int nextR = now[0] + dr[i];
                int nextC = now[1] + dc[i];

                if (!isRange(nextR, nextC)) continue;

                if (board[nextR][nextC] == 1 && !visited[nextR][nextC]) {
                    visited[nextR][nextC] = true;
                    qu.offer(new int[]{nextR, nextC});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(tokenizer.nextToken());
        n = Integer.parseInt(tokenizer.nextToken());
        board = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    res++;
                    bfs(i, j);
                }
            }
        }
        System.out.println(res);
    } // end of main
}