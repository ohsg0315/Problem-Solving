import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n], res = new int[n][n];

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
                res[i][j] = map[i][j];
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == k || j == k) continue;

                    if (map[i][j] > map[i][k] + map[k][j]) {
                        System.out.println("-1");
                        return;
                    }
                    if (map[i][j] == map[i][k] + map[k][j]) {
                        res[i][j] = 0;
                    }
                }
            }
        }
        int total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                total += res[i][j];
            }
        }
        System.out.println(total);
    } // end of main
} // end of class