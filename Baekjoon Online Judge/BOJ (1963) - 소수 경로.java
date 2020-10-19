import java.util.*;
import java.io.*;

public class Main {
    private static int start, goal;
    private static boolean[] isNotPrime, visited;

    // 소수 판별 : 에라토스테네스의 체
    private static void setPrime() {
        isNotPrime = new boolean[10000];

        for (int i = 2; i < 10000; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * 2; j < 10000; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
    }

    // 탐색
    private static int bfs() {
        Queue<int[]> qu = new LinkedList<>();
        visited = new boolean[10000];

        qu.offer(new int[]{start, 0});
        visited[start] = true;

        while (!qu.isEmpty()) {
            int[] now = qu.poll();

            if (now[0] == goal) {
                return now[1];
            }

            // 자리 변경 1033
            int cipher = 1;
            String sub = Integer.toString(now[0]);
            for (int i = 0; i < 4; i++) {
                int cur = now[0] - ((sub.charAt(3 - i) - '0') * cipher);

                for (int j = 0; j < 10; j++) {
                    int next = cur + (j * cipher);

                    if (next < 1000) continue;

                    if (!isNotPrime[next] && !visited[next]) {
                        visited[next] = true;
                        qu.offer(new int[]{next, now[1] + 1});
                    }
                }
                cipher *= 10;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        setPrime();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            start = Integer.parseInt(tokenizer.nextToken());
            goal = Integer.parseInt(tokenizer.nextToken());

            int res = bfs();

            if (res == -1)
                System.out.println("Impossible");
            else
                System.out.println(res);
        }

    } // end of main
}