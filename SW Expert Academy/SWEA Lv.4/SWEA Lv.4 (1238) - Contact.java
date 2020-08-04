import java.util.*;
import java.io.*;

public class Solution {
    private static int[] visited;
    private static ArrayList<Integer>[] graph;

    private static int bfs(int start) {
        Queue<Integer> qu = new LinkedList<>();
        int res = start, cnt = 1;

        visited[start] = 1;
        qu.offer(start);

        while (!qu.isEmpty()) {
            int now = qu.poll();

            if (cnt == visited[now]) {
                if (now > res) {
                    res = now;
                }
            } else if (cnt < visited[now]) {
                res = now;
                cnt = visited[now];
            }

            if (graph[now] != null) {
                for (int i = 0; i < graph[now].size(); i++) {
                    int next = graph[now].get(i);
                    if (visited[next] == 0) {
                        visited[next] = visited[now] + 1;
                        qu.offer(next);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;

        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(tokenizer.nextToken()), start = Integer.parseInt(tokenizer.nextToken());
            visited = new int[101];
            graph = new ArrayList[101];

            tokenizer = new StringTokenizer(br.readLine(), " ");
            while (tokenizer.hasMoreTokens()) {
                int from = Integer.parseInt(tokenizer.nextToken());
                int to = Integer.parseInt(tokenizer.nextToken());

                if (graph[from] == null) {
                    graph[from] = new ArrayList<>();
                }
                graph[from].add(to);
            }
            int res = bfs(start);

            System.out.println("#" + testCase + " " + res);
        }
    }
}