import java.util.*;
import java.io.*;

public class Main {
    private static int res;
    private static int[] order;
    private static final int[] dx = {0, 0, -1, 1, 0, 0};
    private static final int[] dy = {-1, 1, 0, 0, 0, 0};
    private static final int[] dz = {0, 0, 0, 0, -1, 1};
    private static boolean[] isSelected;
    private static int[][][] maze, base;

    private static class Point {
        int x, y, z, cnt;

        public Point(int x, int y, int z, int cnt) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.cnt = cnt;
        }
    }

    // 범위 체크
    private static boolean isRange(int x, int y, int z) {
        return x >= 0 && y >= 0 && z >= 0 && x < 5 && y < 5 && z < 5;
    }

    // 판 돌리기
    private static int[][] rotate(int[][] cur) {
        int[][] next = new int[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                next[i][j] = cur[4 - j][i];
            }
        }
        return next;
    }

    // 미로 세팅
    private static void setMaze() {
        maze = new int[5][5][5];

        // 층 순서 설정
        for (int i = 0; i < 5; i++) {
            maze[i] = base[order[i]];
        }
        for (int i = 0; i < 4; i++) {
            maze[0] = rotate(maze[0]);

            if (maze[0][0][0] == 0) continue;

            for (int j = 0; j < 4; j++) {
                maze[1] = rotate(maze[1]);
                for (int k = 0; k < 4; k++) {
                    maze[2] = rotate(maze[2]);
                    for (int l = 0; l < 4; l++) {
                        maze[3] = rotate(maze[3]);
                        for (int m = 0; m < 4; m++) {
                            maze[4] = rotate(maze[4]);
                            if (maze[4][4][4] == 0) continue;
                            bfs();
                        }
                    }
                }
            }
        } // end of for
    }

    // 탐색
    private static void bfs() {
        boolean[][][] visited = new boolean[5][5][5];
        Queue<Point> qu = new LinkedList<>();

        visited[0][0][0] = true;
        qu.offer(new Point(0, 0, 0, 0));

        while (!qu.isEmpty()) {
            Point p = qu.poll();

            if (p.x == 4 && p.y == 4 && p.z == 4) {
                if (p.cnt < res) {
                    res = p.cnt;
                }
                return;
            }
            for (int i = 0; i < 6; i++) {
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];
                int nextZ = p.z + dz[i];

                if (!isRange(nextX, nextY, nextZ)) continue;

                if (maze[nextZ][nextY][nextX] == 1 && !visited[nextZ][nextY][nextX]) {
                    qu.offer(new Point(nextX, nextY, nextZ, p.cnt + 1));
                    visited[nextZ][nextY][nextX] = true;
                }
            }
        }
    }

    // 순열 - 층 순서 정하기
    private static void permutation(int cnt) {
        if (cnt == 5) {
            setMaze();
            return;
        }
        for (int i = 0; i < 5; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                order[cnt] = i;
                permutation(cnt + 1);
                isSelected[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        res = Integer.MAX_VALUE;
        order = new int[5];
        isSelected = new boolean[5];
        base = new int[5][5][5];

        for (int i = 0; i < 5; i++) {

        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tokenizer = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < 5; k++) {
                    base[i][j][k] = Integer.parseInt(tokenizer.nextToken());
                }
            }
        }
        permutation(0);
        if (res == Integer.MAX_VALUE) res = -1;
        System.out.println(res);
    } // end of main
} // end of class