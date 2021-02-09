import java.io.*;
import java.util.*;

public class Main {
    private static int F, S, G, U, D;

    private static int BFS() {
        Queue<int[]> qu = new LinkedList<>();
        boolean[] visited = new boolean[F + 1];

        qu.offer(new int[]{S, 0});
        visited[S] = true;

        while (!qu.isEmpty()) {
            int cur = qu.peek()[0];
            int dist = qu.poll()[1];

            if (cur == G)
                return dist;

            // 위로 이동
            if (cur + U <= F && !visited[cur + U]) {
                visited[cur + U] = true;
                qu.offer(new int[]{cur + U, dist + 1});
            }
            // 아래로 이동
            if (cur - D > 0 && !visited[cur - D]) {
                visited[cur - D] = true;
                qu.offer(new int[]{cur - D, dist + 1});
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        F = Integer.parseInt(tokenizer.nextToken());
        S = Integer.parseInt(tokenizer.nextToken());
        G = Integer.parseInt(tokenizer.nextToken());
        U = Integer.parseInt(tokenizer.nextToken());
        D = Integer.parseInt(tokenizer.nextToken());

        int res = BFS();
        if (res != -1) {
            System.out.println(res);
        } else {
            System.out.println("use the stairs");
        }
    } // end of main
} // end of class