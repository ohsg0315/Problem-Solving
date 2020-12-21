import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        boolean[][] board = new boolean[100][100];

        for (int i = 0; i < 4; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");

            int lc = Integer.parseInt(tokenizer.nextToken()) - 1;
            int lr = Integer.parseInt(tokenizer.nextToken()) - 1;
            int rc = Integer.parseInt(tokenizer.nextToken()) - 1;
            int rr = Integer.parseInt(tokenizer.nextToken()) - 1;

            for (int r = lr; r < rr; r++) {
                for (int c = lc; c < rc; c++) {
                    board[r][c] = true;
                }
            }
        }
        int total = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (board[i][j]) total++;
            }
        }
        System.out.println(total);
    } // end of main
} // end of class