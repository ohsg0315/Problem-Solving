import java.util.*;
import java.io.*;

public class Main {
    private static int n, res;
    private static int[] t, p;

    private static void dfs(int total, int cnt) {
        if (cnt == n) {
            if (res < total) {
                res = total;
            }
            return;
        }
        // 일 한다.
        if (cnt + t[cnt] <= n) {
            dfs(total + p[cnt], cnt + t[cnt]);
        }

        // 하루 건너 뛴다.
        dfs(total, cnt + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        n = Integer.parseInt(br.readLine());
        t = new int[n];
        p = new int[n];

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine());

            t[i] = Integer.parseInt(tokenizer.nextToken());
            p[i] = Integer.parseInt(tokenizer.nextToken());
        }
        dfs(0, 0);
        System.out.println(res);
    } // end of main
} // end of class