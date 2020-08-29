import java.util.*;
import java.io.*;

public class Main {
    private static int n, m, total, res;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static int[] order;
    private static char[][] map;
    private static boolean[][] visited;
    private static ArrayList<Point> viruses;
    private static Queue<Point> after;

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }

    private static int bfs() {
        int virus = 0;
        Queue<Point> qu = new LinkedList<>();

        while (!after.isEmpty()) {
            qu.offer(after.poll());
        }

        // 활성 바이러스
        for (int i = 0; i < m; i++) {
            Point p = viruses.get(order[i]);
            qu.offer(p);
            visited[p.y][p.x] = true;
        }

        while (!qu.isEmpty()) {
            Point p = qu.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];

                if (!isRange(nextX, nextY) || map[nextY][nextX] == '1' || visited[nextY][nextX]) continue;

                if (map[nextY][nextX] == '0') {
                    virus++;
                }
                visited[nextY][nextX] = true;
                after.offer(new Point(nextX, nextY));
            }
        }
        return virus;
    }

    private static void combination(int idx, int cnt) {
        if (cnt == m) {
            int time = 0, virus = total;
            visited = new boolean[n][n];
            after = new LinkedList<>();
            while (virus > 0) {
                virus -= bfs();
                if (after.size() == 0) {
                    time = Integer.MAX_VALUE;
                    break;
                }
                time++;
            }
            if (time < res) res = time;
            return;
        }
        for (int i = idx, size = viruses.size(); i < size; i++) {
            order[cnt] = i;
            combination(i + 1, cnt + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        res = Integer.MAX_VALUE;
        order = new int[m];
        map = new char[n][n];
        viruses = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] buf = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = buf[j].charAt(0);
                if (map[i][j] == '0') {
                    total++;
                } else if (map[i][j] == '2') {
                    viruses.add(new Point(j, i));
                }
            }
        }
        combination(0, 0);
        if (res == Integer.MAX_VALUE) res = -1;
        System.out.println(res);
    } // end of main
} // end of class