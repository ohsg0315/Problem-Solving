import java.util.*;
import java.io.*;

public class Main {
    private static int n, m, res;
    private static ArrayList<Point> cctv;

    private static class Point {
        int x;
        int y;
        int type;

        public Point(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    private static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

    private static char[][] deepCopy(char[][] cur) {
        char[][] next = new char[n][m];

        for (int i = 0; i < n; i++) {
            if (m >= 0) System.arraycopy(cur[i], 0, next[i], 0, m);
        }
        return next;
    }

    private static void update(char[][] next, Point p, int direction) {
        direction %= 4;
        int x = p.x;
        int y = p.y;
        switch (direction) {
            case 0: // 북
                while (isRange(x, --y) && next[y][x] != '6') {
                    next[y][x] = '#';
                }
                break;
            case 1: // 동
                while (isRange(++x, y) && next[y][x] != '6') {
                    next[y][x] = '#';
                }
                break;
            case 2: // 남
                while (isRange(x, ++y) && next[y][x] != '6') {
                    next[y][x] = '#';
                }
                break;
            case 3: // 서
                while (isRange(--x, y) && next[y][x] != '6'){
                next[y][x] = '#';
                }
                break;
        }
    }

    private static void search(char[][] cur, int cnt) {
        if (cnt == cctv.size()) {
            int total = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (cur[i][j] == '0') {
                        total++;
                    }
                }
            }
            if (total < res) {
                res = total;
            }
            return;
        } // end of if

        Point p = cctv.get(cnt);
        for (int i = 0; i < 4; i++) {
            char[][] next = deepCopy(cur);

            switch (p.type) {
                case 1:
                    update(next, p, i);
                    break;
                case 2:
                    update(next, p, i);
                    update(next, p, i + 2);
                    i += 2; // 중복 제거
                    break;
                case 3:
                    update(next, p, i);
                    update(next, p, i + 1);
                    break;
                case 4:
                    update(next, p, i);
                    update(next, p, i + 1);
                    update(next, p, i + 2);
                    break;
                case 5:
                    update(next, p, i);
                    update(next, p, i + 1);
                    update(next, p, i + 2);
                    update(next, p, i + 3);
                    i += 3; // 중복 제거
                    break;
            } // end of switch
            search(next, cnt + 1);
        } // end of for
    } // end of method

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        res = Integer.MAX_VALUE;
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        char[][] map = new char[n][m];
        cctv = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = tokenizer.nextToken().charAt(0);

                if ('0' < map[i][j] && map[i][j] < '6') {
                    cctv.add(new Point(j, i, map[i][j] - '0'));
                }
            }
        }

        search(map, 0);
        System.out.println(res);
    } // end of main
} // end of class