import java.util.*;
import java.io.*;

public class Main {
    private static int n, res;
    private static int[] dx = {1, 1, 1, 0};
    private static int[] dy = {-1, 0, 1, 1};
    private static int[][] board;

    private static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < 19 && y < 19;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        n = 19;
        board = new int[n][n];
        for (int i = 0; i < 19; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (board[i][j] != 0) {
                    for (int direction = 0; direction < 4; direction++) {
                        int nextX = j + dx[direction];
                        int nextY = i + dy[direction];

                        if (isRange(nextX, nextY) && board[nextY][nextX] == board[i][j]) {
                            int cnt = 1;

                            int beforeX = j - dx[direction];
                            int beforeY = i - dy[direction];
                            if (isRange(beforeX, beforeY) && board[beforeY][beforeX] == board[i][j]) continue;

                            while (isRange(nextX, nextY) && board[nextY][nextX] == board[i][j]) {
                                cnt++;
                                nextX += dx[direction];
                                nextY += dy[direction];
                            }
                            if (cnt == 5) {
                                res = board[i][j];
                                System.out.println(res);
                                System.out.println((i + 1) + " " + (j + 1));
                                return;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(res);
    } // end of main
} // end of class