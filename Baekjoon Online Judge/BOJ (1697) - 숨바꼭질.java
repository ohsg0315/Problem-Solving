import java.util.*;
import java.io.*;

public class Main {
    private static int N, K;
    private static int[] dx = {-1, 1, 2};
    private static boolean[] visited = new boolean[100001];
    ;

    private static class Current {
        int x, cnt;

        public Current(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }

    private static int BFS(int now) {
        Queue<Current> qu = new LinkedList<>();
        qu.offer(new Current(now, 0));
        visited[now] = true;

        while (!qu.isEmpty()) {
            Current cur = qu.poll();

            if (cur.x == K) {
                return cur.cnt;
            }

            for (int i = 0; i < 3; i++) {
                int x = cur.x;

                if (i == 2) {
                    x *= dx[i];
                } else {
                    x += dx[i];
                }

                if (x >= 0 && x <= 100000 && !visited[x]) {
                    visited[x] = true;
                    qu.offer(new Current(x, cur.cnt + 1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());


        int res = BFS(N);
        System.out.println(res);
    } // end of main
} // end of class