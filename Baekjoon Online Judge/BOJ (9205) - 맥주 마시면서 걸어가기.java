import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int[][] point;
    private static boolean res;
    private static boolean[] visited;

    private static int calDist(int curX, int curY, int destX, int destY) {
        return Math.abs(curX - destX) + Math.abs(curY - destY);
    }

    private static void dfs(int x, int y) {
        if (visited[n]) {
            res = true;
            return;
        }
        for (int i = 0; i < n + 1; i++) {
            int dist = calDist(x, y, point[i][0], point[i][1]);

            if (!visited[i] && dist <= 1000) {
                visited[i] = true;
                dfs(point[i][0], point[i][1]);

                if (res) {
                    return;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            res = false;
            n = Integer.parseInt(br.readLine());
            tokenizer = new StringTokenizer(br.readLine(), " ");
            int startX = Integer.parseInt(tokenizer.nextToken());
            int startY = Integer.parseInt(tokenizer.nextToken());
            point = new int[n + 1][2];
            visited = new boolean[n + 1];

            for (int i = 0; i < n + 1; i++) {
                tokenizer = new StringTokenizer(br.readLine());
                point[i][0] = Integer.parseInt(tokenizer.nextToken());
                point[i][1] = Integer.parseInt(tokenizer.nextToken());
            }

            dfs(startX, startY);
            if (res) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
        }

    } // end of main
} // end of class