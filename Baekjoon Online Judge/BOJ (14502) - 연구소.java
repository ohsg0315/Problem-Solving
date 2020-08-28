import java.util.*;
import java.io.*;

public class Main {
    private static int n, m, total, res;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static char[][] map, simul;
    private static boolean[][] visited;
    private static ArrayList<Point> list, wall;

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

    private static void deepCopy() {
        simul = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                simul[i][j] = map[i][j];
            }
        }
    }

    private static int search() {
        int virus = 0;
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (simul[i][j] == '2' && !visited[i][j]) {
                    for (int direction = 0; direction < 4; direction++) {
                        int nextX = j + dx[direction];
                        int nextY = i + dy[direction];

                        if (!isRange(nextX, nextY)) continue;

                        if (simul[nextY][nextX] == '0' && !visited[nextY][nextX]) {
                            simul[nextY][nextX] = '2';
                            visited[nextY][nextX] = true;
                            virus++;
                        }
                    }
                }
            }
        }
        return virus;
    }

    private static void combination(int idx, int cnt) {
        if (cnt == 3) {
            deepCopy();
            for (int i = 0; i < cnt; i++) {
                int x = wall.get(i).x;
                int y = wall.get(i).y;

                simul[y][x] = '*';
            }
            int virus = 1, safe = total - 3;
            while (virus != 0) {
                virus = search();
                safe -= virus;
            }
            if (safe > res) res = safe;
            return;
        }
        for (int i = idx, size = list.size(); i < size; i++) {
            wall.add(list.get(i));
            combination(i + 1, cnt + 1);
            wall.remove(cnt);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        map = new char[n][m];
        wall = new ArrayList<>();
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] buf = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = buf[j].charAt(0);

                if (map[i][j] == '0') {
                    list.add(new Point(j, i));
                    total++;
                }
            }
        }
        combination(0, 0);
        System.out.println(res);
    } // end of main
} // end of class