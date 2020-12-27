import java.io.*;
import java.util.*;

public class Main {
    private static int n, m;
    private static int[] list, res;
    private static boolean[] selected;
    private static StringBuilder sb;

    private static void permutation(int cnt) {
        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                sb.append(res[i]).append(' ');
            }
            sb.setCharAt(sb.length() - 1, '\n');
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!selected[i]) {
                selected[i] = true;
                res[cnt] = list[i];
                permutation(cnt + 1);
                selected[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        tokenizer = new StringTokenizer(br.readLine(), " ");

        list = new int[n];
        res = new int[m];
        selected = new boolean[n];
        sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(list);
        permutation(0);
        System.out.print(sb.toString());
    } // end of main
} // end of class