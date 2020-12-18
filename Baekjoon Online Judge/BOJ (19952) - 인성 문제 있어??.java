import java.io.*;
import java.util.*;

public class Main {
    private static int H, W, O, F, startC, startR, endC, endR;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int[][] map;
    private static boolean[][] visited;

    private static boolean isRange(int r, int c) {
        return r >= 0 && r < H && c >= 0 && c < W;
    }

    private static boolean BFS() {
        Queue<int[]> qu = new LinkedList<>();

        qu.offer(new int[]{startR, startC, F});
        visited[startR][startC] = true;

        while (!qu.isEmpty()) {
            int[] now = qu.poll();


            for (int i = 0; i < 4; i++) {
                int nextR = now[0] + dr[i];
                int nextC = now[1] + dc[i];

                if (!isRange(nextR, nextC)) continue;
                if (map[nextR][nextC] - map[now[0]][now[1]] > now[2] || visited[nextR][nextC]) continue;

                if (nextR == endR && nextC == endC) return true;

                qu.offer(new int[]{nextR, nextC, now[2] - 1});
                visited[nextR][nextC] = true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            H = Integer.parseInt(tokenizer.nextToken());
            W = Integer.parseInt(tokenizer.nextToken());
            O = Integer.parseInt(tokenizer.nextToken());
            F = Integer.parseInt(tokenizer.nextToken());
            startR = Integer.parseInt(tokenizer.nextToken()) - 1;
            startC = Integer.parseInt(tokenizer.nextToken()) - 1;
            endR = Integer.parseInt(tokenizer.nextToken()) - 1;
            endC = Integer.parseInt(tokenizer.nextToken()) - 1;

            map = new int[H][W];
            visited = new boolean[H][W];

            for (int i = 0; i < O; i++) {
                tokenizer = new StringTokenizer(br.readLine(), " ");

                int r = Integer.parseInt(tokenizer.nextToken()) - 1;
                int c = Integer.parseInt(tokenizer.nextToken()) - 1;
                int L = Integer.parseInt(tokenizer.nextToken());
                map[r][c] = L;

            }
            if (BFS())
                sb.append("잘했어!!").append('\n');
            else
                sb.append("인성 문제있어??").append('\n');
        } // end of while
        System.out.println(sb.toString());
    } // end of main
}