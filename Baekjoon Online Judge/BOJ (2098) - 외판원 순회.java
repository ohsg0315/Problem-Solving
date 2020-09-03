import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int[][] map, cache;

    private static long tsp(int node, int visit) {
        if (visit == (1 << n) - 1) {
            if (map[node][0] != 0) {
                return map[node][0];
            }
            return Integer.MAX_VALUE;
        }

        if (cache[node][visit] != -1) return cache[node][visit];

        long res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if ((visit & (1 << i)) == 0 && map[node][i] > 0) {
                res = Math.min(res, tsp(i, visit | (1 << i)) + map[node][i]);
            }
        }
        return cache[node][visit] = (int) res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        cache = new int[n][1 << n];

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            Arrays.fill(cache[i], -1);
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        long res = tsp(0, 1);
        System.out.println(res);
    } // end of main
} // end of class