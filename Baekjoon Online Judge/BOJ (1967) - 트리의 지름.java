import java.util.*;
import java.io.*;

public class Main {
    private static int n, res;
    private static int[] cache;
    private static ArrayList<int[]>[] list;

    private static int dfs(int parent) {
        if (cache[parent] != -1) return cache[parent];

        int size = list[parent].size();

        if (size == 0) {
            return cache[parent] = 0;
        } else if (size == 1) {
            int[] child = list[parent].get(0);
            int weight = dfs(child[0]);

            res = Math.max(res, child[1] + weight);
            return cache[parent] = child[1] + weight;
        } else {
            list[0].clear();
            ArrayList<Integer> weights = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int[] child = list[parent].get(i);
                int weight = dfs(child[0]) + child[1];
                weights.add(weight);
            }
            Collections.sort(weights, Collections.reverseOrder());
            int first = weights.get(0), second = weights.get(1);

            res = Math.max(res, first + second);
            return cache[parent] = first;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        n = Integer.parseInt(br.readLine());
        cache = new int[n + 1];
        list = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            cache[i] = -1;
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");

            int parent = Integer.parseInt(tokenizer.nextToken());
            int child = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken());

            list[parent].add(new int[]{child, weight});
        }
        for (int i = n; i > 0; i--) {
            dfs(i);
        }
        System.out.println(res);
    } // end of main
} // end of class