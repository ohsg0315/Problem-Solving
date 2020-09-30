import java.util.*;
import java.io.*;

public class Main {
    private static int n, m, res;
    private static int[][] map;
    private static int[][][] shape = {
            {{0, 0}, {0, 1}, {0, 2}, {0, 3}}, // I
            {{0, 0}, {1, 0}, {2, 0}, {3, 0}},
            {{0, 0}, {0, 1}, {1, 0}, {1, 1}}, // ㅁ
            {{0, 0}, {0, 1}, {0, 2}, {1, 2}}, // L
            {{0, 0}, {1, 0}, {2, 0}, {2, -1}},
            {{0, 0}, {1, 0}, {1, 1}, {1, 2}},
            {{0, 0}, {1, 0}, {2, 0}, {0, 1}},
            {{0, 0}, {1, 0}, {1, -1}, {1, -2}},
            {{0, 0}, {1, 0}, {2, 0}, {2, 1}},
            {{0, 0}, {1, 0}, {0, 1}, {0, 2}},
            {{0, 0}, {0, 1}, {1, 1}, {2, 1}},
            {{0, 0}, {0, 1}, {1, 1}, {1, 2}}, // ㄹ
            {{0, 0}, {1, 0}, {1, -1}, {2, -1}},
            {{0, 0}, {0, -1}, {1, -1}, {1, -2}},
            {{0, 0}, {1, 0}, {1, 1}, {2, 1}},
            {{0, 0}, {0, 1}, {0, 2}, {1, 1}}, // ㅏ
            {{0, 0}, {1, 0}, {1, 1}, {2, 0}},
            {{0, 0}, {1, 0}, {2, 0}, {1, -1}},
            {{0, 0}, {0, 1}, {0, 2}, {-1, 1}}
    };

    private static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

    private static void tetromino(int x, int y) {
        for (int i = 0, size = shape.length; i < size; i++) {
            int total = 0;
            for (int j = 0; j < 4; j++) {
                int nextX = x + shape[i][j][0];
                int nextY = y + shape[i][j][1];

                if (!isRange(nextX, nextY)) continue;

                total += map[nextY][nextX];
            }
            res = Math.max(res, total);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tetromino(j, i);
            }
        }
        System.out.println(res);
    }
}