import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int[][] a = new int[n][m];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            sb.setLength(0);
            for (int j = 0; j < m; j++) {
                a[i][j] += Integer.parseInt(tokenizer.nextToken());
                sb.append(a[i][j]).append(' ');
            }
            System.out.println(sb.toString().trim());
        }
    }
}