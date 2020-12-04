import java.io.*;
import java.util.*;

public class Main {
    private static int n, m;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int[][] board;
    private static boolean[][] visited;

    private static boolean isRange(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }

    private static int bfs(int r, int c) {
        int size = 0;
        Queue<int[]> qu = new LinkedList<>();

        qu.offer(new int[]{r, c});
        visited[r][c] = true;

        while (!qu.isEmpty()) {
            size++;
            int[] now = qu.poll();

            for (int i = 0; i < 4; i++) {
                int nextR = now[0] + dr[i];
                int nextC = now[1] + dc[i];

                if (!isRange(nextR, nextC)) continue;

                if (board[nextR][nextC] == 1 && !visited[nextR][nextC]) {
                    qu.offer(new int[]{nextR, nextC});
                    visited[nextR][nextC] = true;
                }
            }
        }
        return size;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        int res = 0, size = 0;
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        board = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    res++;
                    size = Math.max(size, bfs(i, j));
                }
            }
        }
        System.out.println(res);
        System.out.println(size);
    } // end of main
}