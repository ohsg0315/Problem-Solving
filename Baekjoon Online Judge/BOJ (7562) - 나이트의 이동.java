import java.io.*;
import java.util.*;

public class Main {
    private static int l, endR, endC;
    private static int[] dr = {-2, -1, 1, 2, -2, -1, 1, 2};
    private static int[] dc = {-1, -2, -2, -1, 1, 2, 2, 1};
    private static boolean[][] visited;

    private static boolean isRange(int r, int c) {
        return 0 <= r && r < l && 0 <= c && c < l;
    }

    private static int BFS(int startR, int startC) {
        Queue<int[]> qu = new LinkedList<>();

        if(startR == endR && startC == endC) return 0;

        qu.offer(new int[]{startR, startC, 0});
        visited[startR][startC] = true;

        while (!qu.isEmpty()) {
            int[] now = qu.poll();

            for (int i = 0; i < 8; i++) {
                int nextR = now[0] + dr[i];
                int nextC = now[1] + dc[i];

                if (!isRange(nextR, nextC)) continue;

                if (nextR == endR && nextC == endC) return now[2] + 1;

                else if (!visited[nextR][nextC]) {
                    qu.offer(new int[]{nextR, nextC, now[2] + 1});
                    visited[nextR][nextC] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer tokenizer;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            l = Integer.parseInt(br.readLine());
            visited = new boolean[l][l];

            tokenizer = new StringTokenizer(br.readLine(), " ");
            int startR = Integer.parseInt(tokenizer.nextToken());
            int startC = Integer.parseInt(tokenizer.nextToken());

            tokenizer = new StringTokenizer(br.readLine(), " ");
            endR = Integer.parseInt(tokenizer.nextToken());
            endC = Integer.parseInt(tokenizer.nextToken());

            sb.append(BFS(startR, startC)).append('\n');
        }
        System.out.print(sb.toString());
    } // end of main
} // end of class