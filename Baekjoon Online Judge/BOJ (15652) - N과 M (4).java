import java.util.*;
import java.io.*;

public class Main {
    private static int n, r;
    private static int[] res;

    private static void combination(BufferedWriter bw, int idx, int cnt) throws IOException {
        if (cnt == r) {
            for (int i = 0; i < r - 1; i++) {
                bw.write(res[i] + " ");
            }
            bw.write(res[r - 1] + "\n");
            return;
        }
        for (int i = idx; i < n + 1; i++) {
            res[cnt] = i;
            combination(bw, i, cnt + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(tokenizer.nextToken());
        r = Integer.parseInt(tokenizer.nextToken());
        res = new int[r];

        combination(bw, 1,0);
        bw.close();

    } // end of main
} // end of class