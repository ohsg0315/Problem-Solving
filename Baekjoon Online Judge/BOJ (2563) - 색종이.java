import java.util.*;
import java.io.*;

public class Main {
    private static boolean[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        board = new boolean[101][101];
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());

            for (int j = y; j < y + 10; j++) {
                for (int k = x; k < x + 10; k++) {
                    board[j][k] = true;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (board[i][j]) sum++;
            }
        }

        System.out.println(sum);
    } // end of main
} // end of class