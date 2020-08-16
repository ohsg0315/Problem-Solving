import java.util.*;
import java.io.*;

public class Main {
    private static int n, m;
    private static int[] command;
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int[][] map, dice;

    private static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

    private static void move(int direction) {
        int tmp;
        switch (direction) {
            case 1: // 동쪽
                tmp = dice[1][2];
                dice[1][2] = dice[1][1];
                dice[1][1] = dice[1][0];
                dice[1][0] = dice[3][1];
                dice[3][1] = tmp;
                break;
            case 2: // 서쪽
                tmp = dice[1][0];
                dice[1][0] = dice[1][1];
                dice[1][1] = dice[1][2];
                dice[1][2] = dice[3][1];
                dice[3][1] = tmp;
                break;
            case 3: // 북쪽
                tmp = dice[0][1];
                for (int i = 0; i < 3; i++) {
                    dice[i][1] = dice[i + 1][1];
                }
                dice[3][1] = tmp;
                break;
            case 4: // 남쪽
                tmp = dice[3][1];
                for (int i = 3; i > 0; i--) {
                    dice[i][1] = dice[i - 1][1];
                }
                dice[0][1] = tmp;
                break;
        }
    }

    private static void playGame(int x, int y) {
        for (int cur : command) {
            if (!isRange(x + dx[cur - 1], y + dy[cur - 1]))
                continue;

            x += dx[cur - 1];
            y += dy[cur - 1];

            move(cur);
            if (map[y][x] == 0) { // 지도가 0
                map[y][x] = dice[3][1];
            } else { // 0이 아님
                dice[3][1] = map[y][x];
                map[y][x] = 0;
            }
            System.out.println(dice[1][1]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        int x = Integer.parseInt(tokenizer.nextToken());
        int y = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        command = new int[k];
        tokenizer = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < k; i++) {
            command[i] = Integer.parseInt(tokenizer.nextToken());
        }

        dice = new int[4][3];
        playGame(y, x);
    } // end of main
} // end of class