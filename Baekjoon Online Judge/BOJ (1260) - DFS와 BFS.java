import java.util.*;
import java.io.*;

public class Main {
    private static int N, M;
    private static boolean[] visited;
    private static boolean[][] map;
    private static StringBuilder sb;

    private static void DFS(int start) {
        for (int i = 1; i <= N; i++) {
            if (map[start][i] && !visited[i]) {
                sb.append(i + " ");
                visited[i] = true;
                DFS(i);
            }
        }
    }

    private static void BFS(int start) {
        Queue<Integer> qu = new LinkedList<>();

        qu.offer(start);
        while (!qu.isEmpty()) {
            int now = qu.poll();

            sb.append(now + " ");
            for (int i = 1; i <= N; i++) {
                if (map[now][i] && !visited[i]) {
                    qu.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        int start = Integer.parseInt(tokenizer.nextToken());
        map = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());

            map[a][b] = true;
            map[b][a] = true;
        }

        sb = new StringBuilder();
        sb.append(start + " ");
        visited = new boolean[N + 1];
        visited[start] = true;
        DFS(start);
        System.out.println(sb.toString().trim());

        sb = new StringBuilder();
        visited = new boolean[N + 1];
        visited[start] = true;
        BFS(start);
        System.out.println(sb.toString().trim());
    } // end of main
} // end of class