import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        board = new int[101][101];
        N = Integer.parseInt(br.readLine());
        int cnt = 1;
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");

            int startX = Integer.parseInt(tokenizer.nextToken());
            int startY = Integer.parseInt(tokenizer.nextToken());
            int endX = startX + Integer.parseInt(tokenizer.nextToken());
            int endY = startY + Integer.parseInt(tokenizer.nextToken());

            for (int y = startY; y < endY; y++) {
                for (int x = startX; x < endX; x++) {
                    board[y][x] = cnt;
                }
            }
            cnt++;
        }
        int[] res = new int[N + 1];
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                res[board[i][j]]++;
            }
        }
        for (int i = 1; i < N + 1; i++) {
            System.out.println(res[i]);
        }
    }
}
