import java.util.*;
import java.io.*;

public class Main {
    private static int n, res;
    private static int[] people;
    private static boolean[] selected, visited;
    private static ArrayList<Integer>[] list;

    private static boolean isConnected(ArrayList<Integer> a, ArrayList<Integer> b) {
        Queue<Integer> qu = new LinkedList<>();
        visited = new boolean[n + 1];
        qu.offer(a.get(0));
        visited[a.get(0)] = true;

        while (!qu.isEmpty()) {
            int now = qu.poll();

            for (int i = 0, size = list[now].size(); i < size; i++) {
                int next = list[now].get(i);

                if (visited[next] || !a.contains(next)) continue;

                visited[next] = true;
                qu.offer(next);
            }
        }
        for (Integer integer : a) {
            if (!visited[integer])
                return false;
        }

        qu.offer(b.get(0));
        visited[b.get(0)] = true;
        while (!qu.isEmpty()) {
            int now = qu.poll();

            for (int i = 0, size = list[now].size(); i < size; i++) {
                int next = list[now].get(i);

                if (!visited[next]) {
                    visited[next] = true;
                    qu.offer(next);
                }
            }
        }

        for (Integer integer : b) {
            if (!visited[integer]) return false;
        }
        return true;
    }

    private static void combination(int idx, int cnt) {
        if (cnt == n)
            return;
        else if (cnt > 0) {
            int first = 0, second = 0;
            ArrayList<Integer> a = new ArrayList<>();
            ArrayList<Integer> b = new ArrayList<>();


            for (int i = 1; i < n + 1; i++) {
                if (selected[i]) {
                    a.add(i);
                    first += people[i];
                } else {
                    b.add(i);
                    second += people[i];
                }
            }
            int diff = Math.abs(first - second);

            if (diff < res && isConnected(a, b)) res = diff;
        }
        for (int i = idx; i < n + 1; i++) {
            selected[i] = true;
            combination(i + 1, cnt + 1);
            selected[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        n = Integer.parseInt(br.readLine());
        res = Integer.MAX_VALUE;
        people = new int[n + 1];
        selected = new boolean[n + 1];
        list = new ArrayList[n + 1];
        tokenizer = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < n + 1; i++) {
            people[i] = Integer.parseInt(tokenizer.nextToken());
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i < n + 1; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            tokenizer.nextToken();
            while (tokenizer.hasMoreTokens()) {
                list[i].add(Integer.parseInt(tokenizer.nextToken()));
            }
        }
        combination(1, 0);
        if (res == Integer.MAX_VALUE) res = -1;
        System.out.println(res);
    } // end of main
} // end of class