import java.util.*;
import java.io.*;

public class Main {
    private static int[][] map;
    private static int N;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static boolean[][] visited;
    private static ArrayList<Integer> villageCnt = new ArrayList<>();

    private static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static boolean isRange(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N) {
            return false;
        }
        return true;
    }

    private static void BFS(int x, int y) {
        int res = 0;
        Queue<Point> qu = new LinkedList<>();

        qu.offer(new Point(x, y));
        visited[y][x] = true;

        while (!qu.isEmpty()) {
            Point now = qu.poll();
            res++;

            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if (!isRange(nextX, nextY) || map[nextY][nextX] == 0 || visited[nextY][nextX]) {
                    continue;
                }
                visited[nextY][nextX] = true;
                qu.offer(new Point(nextX, nextY));
            }
        }
        villageCnt.add(res);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    BFS(j, i);
                }
            }
        }
        Collections.sort(villageCnt);

        System.out.println(villageCnt.size());
        for (int i : villageCnt) {
            System.out.println(i);
        }

    } // end of main
} // end of class