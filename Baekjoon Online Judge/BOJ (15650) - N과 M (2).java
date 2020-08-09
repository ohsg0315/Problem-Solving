import java.util.*;
import java.io.*;

public class Main {
    private static int n, r;
    private static int[] res;
    private static BufferedWriter wr;

    private static void combination(int idx, int cnt) throws IOException {
        if (cnt == r) {
            for (int i = 0; i < r - 1; i++) {
                wr.write(res[i] + " ");
            }
            wr.write(res[r - 1] + "\n");
            return;
        }
        for (int i = idx; i < n + 1; i++) {
            res[cnt] = i;
            combination(i + 1, cnt + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        wr = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(tokenizer.nextToken());
        r = Integer.parseInt(tokenizer.nextToken());
        res = new int[r];

        combination(1, 0);
        wr.close();
    } // end of main
} // end of class