import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Integer>[] list;
    private static boolean[][] visited;

    private static int BFS(int start, int goal) {
        int res = Integer.MAX_VALUE;
        Queue<int[]> qu = new LinkedList<>();

        qu.offer(new int[]{start, 0});
        while (!qu.isEmpty()) {
            int[] now = qu.poll();

            if (now[0] == goal) return now[1];

            for (int i = 0, size = list[now[0]].size(); i < size; i++) {
                int next = list[now[0]].get(i);
                if (!visited[now[0]][next]) {
                    qu.offer(new int[]{next, now[1] + 1});
                    visited[now[0]][next] = true;
                    visited[next][now[0]] = true;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(tokenizer.nextToken());
        int b = Integer.parseInt(tokenizer.nextToken());
        tokenizer = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        list = new ArrayList[n + 1];
        visited = new boolean[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());

            if (start != end) {
                list[start].add(end);
                list[end].add(start);
            }
        }
        int res = BFS(a, b);
        if (res == Integer.MAX_VALUE) res = -1;
        System.out.println(res);
    } // end of main
} // end of class