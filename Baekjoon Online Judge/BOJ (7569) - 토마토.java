import java.util.*;
import java.io.*;

public class Main {
    private static int n, m, h, tomato, res;
    private static final int[] dx = {0, 0, -1, 1, 0, 0};
    private static final int[] dy = {-1, 1, 0, 0, 0, 0};
    private static final int[] dz = {0, 0, 0, 0, -1, 1};
    private static int[][][] box;
    private static boolean[][][] visited;
    private static Queue<Point> qu, nextQu;

    private static class Point {
        int x, y, z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    private static boolean isRange(int x, int y, int z) {
        return x >= 0 && y >= 0 && z >= 0 && x < m && y < n && z < h;
    }

    private static int affect() {
        int total = 0;

        while (!qu.isEmpty()) {
            Point p = qu.poll();

            for (int i = 0; i < 6; i++) {
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];
                int nextZ = p.z + dz[i];

                if (!isRange(nextX, nextY, nextZ)) continue;

                if (box[nextZ][nextY][nextX] == 0) {
                    total++;
                    box[nextZ][nextY][nextX] = 1;
                    nextQu.offer(new Point(nextX, nextY, nextZ));
                }
            }
        }
        return total;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        m = Integer.parseInt(tokenizer.nextToken());
        n = Integer.parseInt(tokenizer.nextToken());
        h = Integer.parseInt(tokenizer.nextToken());
        box = new int[h][n][m];
        qu = new LinkedList<>();
        nextQu = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                tokenizer = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < m; k++) {
                    box[i][j][k] = Integer.parseInt(tokenizer.nextToken());

                    if (box[i][j][k] == 0) tomato++;
                    if (box[i][j][k] == 1) qu.offer(new Point(k, j, i));
                }
            }
        }
        int total = 1;
        while (total != 0) {
            res++;
            total = affect();
            tomato -= total;
            qu.addAll(nextQu);
            nextQu.clear();
        }
        res = tomato == 0 ? res - 1 : -1;
        System.out.println(res);
    } // end of main
} // end of class