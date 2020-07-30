import java.util.*;
import java.io.*;

class Solution {
    private static int H, W, x, y;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static char[][] map;

    private static boolean isRange(int x, int y) {
        if (x < 0 || y < 0 || x >= W || y >= H) {
            return false;
        }
        return true;
    }

    private static void shoot(char tank) {
        int direct = -1, nextX = x, nextY = y;

        switch (tank) {
            case '^':
                direct = 0;
                break;
            case 'v':
                direct = 1;
                break;
            case '<':
                direct = 2;
                break;
            case '>':
                direct = 3;
                break;
        }

        while (true) {
            nextX += dx[direct];
            nextY += dy[direct];

            if (!isRange(nextX, nextY)) {
                return;
            }
            char cur = map[nextY][nextX];

            if (cur == '#') {
                return;
            } else if (cur == '*') {
                map[nextY][nextX] = '.';
                return;
            }
        }
    }

    private static void move(char control) {
        int direct = -1;
        char shape = ' ';
        switch (control) {
            case 'U':
                direct = 0;
                shape = '^';
                break;
            case 'D':
                direct = 1;
                shape = 'v';
                break;
            case 'L':
                direct = 2;
                shape = '<';
                break;
            case 'R':
                direct = 3;
                shape = '>';
                break;
        }

        int nextX = x + dx[direct];
        int nextY = y + dy[direct];

        if (isRange(nextX, nextY) && map[nextY][nextX] == '.') {
            map[nextY][nextX] = shape;
            map[y][x] = '.';
            x = nextX;
            y = nextY;

        } else {
            map[y][x] = shape;
        }

    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            H = Integer.parseInt(tokenizer.nextToken());
            W = Integer.parseInt(tokenizer.nextToken());
            map = new char[H][W];
            for (int i = 0; i < H; i++) {
                String buf = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = buf.charAt(j);

                    if (map[i][j] == '>' || map[i][j] == '<' || map[i][j] == '^' || map[i][j] == 'v') {
                        x = j;
                        y = i;
                    }
                }
            }


            int N = Integer.parseInt(br.readLine());
            String control = br.readLine();

            for (int i = 0; i < N; i++) {
                char c = control.charAt(i);

                if (c == 'S') {
                    shoot(map[y][x]);
                } else {
                    move(c);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(testCase).append(" ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
            System.out.print(sb.toString());
        } // end of testCase
    } // end of main
} // end of class