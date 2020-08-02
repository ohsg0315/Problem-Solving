import java.util.*;
import java.io.*;

public class Main {
    private static int V, E;
    private static long[][] distances;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(tokenizer.nextToken());
        E = Integer.parseInt(tokenizer.nextToken());
        // 가중치 배열 최대값으로 초기화
        distances = new long[V][V];
        for (int i = 0; i < V; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
        }
        // 간선 입력
        for (int i = 0; i < E; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(tokenizer.nextToken()) - 1;
            int to = Integer.parseInt(tokenizer.nextToken()) - 1;
            int distance = Integer.parseInt(tokenizer.nextToken());
            distances[from][to] = distance;
        }
        // 플로이드 와샬
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                for (int k = 0; k < V; k++) {
                    distances[i][j] = Math.min(distances[i][j], distances[i][k] + distances[k][j]);
                }
            }
        }
        // 사이클의 최소거리 => distance[i][i]가 최소일 때
        long res = Integer.MAX_VALUE;
        for (int i = 0; i < V; i++) {
            res = Math.min(res, distances[i][i]);
        }
        // 경로 찾기가 불가능한 경우
        if (res >= Integer.MAX_VALUE) {
            res = -1;
        }
        System.out.println(res);
    } // end of main
} // end of class