import java.util.*;
import java.io.*;

public class Main {
    private static int n, r;
    private static int[] res;
    private static boolean[] selected;
    private static BufferedWriter wr;

    private static void permutation(int cnt) throws IOException {
        if (cnt == r) {
            for (int i = 0; i < r - 1; i++) {
                wr.write(res[i] + " ");
            }
            wr.write(res[r - 1] + "\n");
            return;
        }
        for (int i = 1; i < n + 1; i++) {
            if (!selected[i]) {
                selected[i] = true;
                res[cnt] = i;
                permutation(cnt + 1);
                selected[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        wr = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(tokenizer.nextToken());
        r = Integer.parseInt(tokenizer.nextToken());
        res = new int[r];
        selected = new boolean[n + 1];

        permutation(0);
        wr.close();
    } // end of main
} // end of class