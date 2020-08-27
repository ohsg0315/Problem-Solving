import java.util.*;
import java.io.*;

public class Solution {
    private static int n, res;
    private static int[][] list;
    private static Point[] places;
    private static boolean visited[];

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void dfs(int total, int cnt, int before) {
        if (cnt == n) {
            total += list[before][1];
            if (res > total) res = total;
            return;
        }
        for (int i = 2; i < n + 2; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(total + list[before][i], cnt + 1, i);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            res = Integer.MAX_VALUE;
            n = Integer.parseInt(br.readLine());
            int index = n + 2;
            places = new Point[index];
            visited = new boolean[index];
            list = new int[index][index];

            tokenizer = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < index; i++) {
                int x = Integer.parseInt(tokenizer.nextToken());
                int y = Integer.parseInt(tokenizer.nextToken());

                places[i] = new Point(x, y);
            }

            for (int i = 0; i < index; i++) {
                for (int j = 0; j < index; j++) {
                    if (i == j) {
                        list[i][j] = Integer.MAX_VALUE;
                        continue;
                    }
                    list[i][j] = Math.abs(places[i].x - places[j].x) + Math.abs(places[i].y - places[j].y);
                }
            }
            dfs(0, 0, 0);
            System.out.println("#" + testCase + " " + res);
        } // end of testCase
    } // end of main
} // end of class