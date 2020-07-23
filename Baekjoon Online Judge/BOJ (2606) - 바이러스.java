import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static boolean[] visited;
    private static boolean[][] computer;
    
    private static void DFS(int now) {
        visited[now] = true;

        for (int i = 1; i < N + 1; i++) {
            if (computer[now][i] && !visited[i]) {
                DFS(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        N = Integer.parseInt(br.readLine());
        int res = -1, E = Integer.parseInt(br.readLine());
        computer = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < E; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());

            computer[a][b] = true;
            computer[b][a] = true;
        }
        DFS(1);
        for (boolean com : visited) {
            if (com) {
                res++;
            }
        }
        System.out.println(res);
    } // end of main
} // end of class