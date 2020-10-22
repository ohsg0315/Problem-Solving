import java.util.*;
import java.io.*;

public class Main {
    private static final int INF = 999_999_999;
    private static int n, m;
    private static int[] res;
    private static int[][] connect;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        res = new int[n + 1];
        connect = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            res[i] = n - 1;
            for (int j = 0; j < n + 1; j++) {
                connect[i][j] = INF;
            }
        }
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");

            int high = Integer.parseInt(tokenizer.nextToken());
            int low = Integer.parseInt(tokenizer.nextToken());
            connect[high][low] = 1;
        }

        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (connect[i][j] > connect[i][k] + connect[k][j]) {
                        connect[i][j] = connect[i][k] + connect[k][j];
                    }
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (connect[i][j] != INF) {
                    res[i]--;
                    res[j]--;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            System.out.println(res[i]);
        }
    } // end of main
} // end of class