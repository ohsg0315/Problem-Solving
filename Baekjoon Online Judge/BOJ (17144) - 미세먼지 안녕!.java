import java.util.*;
import java.io.*;

public class Main {
    private static int r, c, t, res;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static int[][] map;
    private static ArrayList<Point> airRefresh;

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && y < r && x < c;
    }

    private static int[][] deepCopy(int[][] cur) {
        int[][] next = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                next[i][j] = cur[i][j];
            }
        }
        return next;
    }

    private static int[][] spread(int[][] cur) {
        int[][] next = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (cur[i][j] == -1) {
                    next[i][j] = -1;
                } else if (cur[i][j] != 0) {
                    int cnt = 0, dust = cur[i][j] / 5;

                    for (int k = 0; k < 4; k++) {
                        int nextX = j + dx[k];
                        int nextY = i + dy[k];

                        if (!isRange(nextX, nextY) || cur[nextY][nextX] == -1) continue;

                        cnt++;
                        next[nextY][nextX] += dust;
                    }
                    next[i][j] += cur[i][j] - dust * cnt;
                    if (next[i][j] < 0) next[i][j] = 0;
                }
            }
        }
        return next;
    }

    private static int[][] refresh(int[][] cur) {
        int[][] next = deepCopy(cur);

        Point p = airRefresh.get(0);
        int cnt = 0, x = p.x + 1, y = p.y;
        next[y][x] = 0;
        while (cnt < 4) {
            switch (cnt) {
                case 0:
                    if (x + 1 == c) {
                        cnt++;
                        next[y - 1][x] = cur[y][x];
                    } else {
                        next[y][x + 1] = cur[y][x];
                        x++;
                    }
                    break;
                case 1:
                    if (y == 0) {
                        cnt++;
                        next[y][x - 1] = cur[y][x];
                        x--;
                    } else {
                        next[y - 1][x] = cur[y][x];
                        y--;
                    }
                    break;
                case 2:
                    if (x != 0) {
                        next[y][x - 1] = cur[y][x];
                        x--;
                    } else {
                        cnt++;
                    }
                    break;
                case 3:
                    if (y + 1 != p.y) {
                        next[y + 1][x] = cur[y][x];
                        y++;
                    } else {
                        cnt++;
                    }
                    break;
            }
        }

        p = airRefresh.get(1);
        cnt = 0;
        x = p.x + 1;
        y = p.y;
        next[y][x] = 0;
        while (cnt < 4) {
            switch (cnt) {
                case 0:
                    if (x + 1 == c) {
                        cnt++;
                        next[y + 1][x] = cur[y][x];
                    } else {
                        next[y][x + 1] = cur[y][x];
                        x++;
                    }
                    break;
                case 1:
                    if (y + 1 == r) {
                        cnt++;
                        next[y][x - 1] = cur[y][x];
                        x--;
                    } else {
                        next[y + 1][x] = cur[y][x];
                        y++;
                    }
                    break;
                case 2:
                    if (x != 0) {
                        next[y][x - 1] = cur[y][x];
                        x--;
                    } else {
                        cnt++;
                    }
                    break;
                case 3:
                    if (y - 1 != p.y) {
                        next[y - 1][x] = cur[y][x];
                        y--;
                    } else {
                        cnt++;
                    }
                    break;
            }
        }
        return next;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(tokenizer.nextToken());
        c = Integer.parseInt(tokenizer.nextToken());
        t = Integer.parseInt(tokenizer.nextToken());
        map = new int[r][c];
        airRefresh = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
                if (map[i][j] == -1) {
                    airRefresh.add(new Point(j, i));
                }
            }
        }
        while (t-- > 0) {
            map = spread(map);
            map = refresh(map);
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res += map[i][j];
            }
        }
        System.out.println(res + 2);
    } // end of main
} // end of class