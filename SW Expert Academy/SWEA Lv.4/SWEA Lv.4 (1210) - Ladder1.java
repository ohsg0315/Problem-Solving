import java.util.*;
import java.io.*;

class Solution {
    private static int res;
    private static int[] dx = {-1, 1, 0};
    private static int[] dy = {0, 0, -1};
    private static int[][] map;
    private static boolean flag = true;

    private static boolean isRange(int x, int y) {
        if (x < 0 || y < 0 || x >= 100 || y >= 100) {
            return false;
        }
        return true;
    }

    private static void DFS(int x, int y, int direction) {
        if (y == 0) {
            res = x;
            flag = false;
            return;
        }

        for (int i = 0; i < 3; i++) {
            int nextX = x + dx[i], nextY = y + dy[i];

            if (flag && isRange(nextX, nextY) && map[nextY][nextX] == 1) {
                if (i == 0 && (direction == 0 || direction == 2)) {
                    DFS(nextX, nextY, i);
                } else if (i == 1 && (direction == 1 || direction == 2)) {
                    DFS(nextX, nextY, i);
                } else if (i == 2) {
                    DFS(nextX, nextY, i);
                }
            }
        }
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        int T = 10;

        for (int testCase = 1; testCase <= T; testCase++) {
            res = -1;
            flag = true;
            int x = -1, y = -1, N = Integer.parseInt(br.readLine());
            map = new int[100][100];
            for (int i = 0; i < 100; i++) {
                tokenizer = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < 100; j++) {
                    map[i][j] = Integer.parseInt(tokenizer.nextToken());
                    if (map[i][j] == 2) {
                        x = j;
                        y = i;
                    }
                }
            }
            DFS(x, y, 2);
            System.out.println("#" + testCase + " " + res);
        } // end of testCase
    } // end of main
} // end of class