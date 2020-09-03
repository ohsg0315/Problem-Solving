import java.util.*;
import java.io.*;

public class Solution {
    private static int n, maxCore, minLine, size;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static char[][] board;
    private static ArrayList<int[]> core;

    private static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }

    private static boolean isPossible(int x, int y, int dir) {
        x += dx[dir];
        y += dy[dir];

        while (true) {
            if (!isRange(x, y)) return true;
            if (board[y][x] != '0') return false;

            x += dx[dir];
            y += dy[dir];
        }
    }

    private static int setLine(int x, int y, int dir, char c) {
        int cnt = 0;
        x += dx[dir];
        y += dy[dir];

        while (isRange(x, y)) {
            board[y][x] = c;
            x += dx[dir];
            y += dy[dir];
            cnt++;
        }
        return cnt;
    }

    private static void dfs(int total, int cnt, int link) {
        if (cnt == size) {
            if (link > maxCore) {
                maxCore = link;
                minLine = total;
            } else if (link == maxCore && total < minLine) minLine = total;
            return;
        }

        int x = core.get(cnt)[0];
        int y = core.get(cnt)[1];

        for (int i = 0; i < 4; i++) {
            if (isPossible(x, y, i)) {
                dfs(total + setLine(x, y, i, '*'), cnt + 1, link + 1);
                setLine(x, y, i, '0');
            }
        }
        dfs(total, cnt + 1, link);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            size = 0;
            maxCore = 0;
            minLine = Integer.MAX_VALUE;
            n = Integer.parseInt(br.readLine());
            board = new char[n][n];
            core = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                tokenizer = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    board[i][j] = tokenizer.nextToken().charAt(0);

                    if (board[i][j] == '1' && i != 0 && i != n - 1 && j != 0 && j != n - 1) {
                        size++;
                        core.add(new int[]{j, i});
                    }
                }
            }
            dfs(0, 0, 0);
            System.out.println("#" + testCase + " " + minLine);
        } // end of testCase
    } // end of main
} // end of class