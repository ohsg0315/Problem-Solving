import java.io.*;
import java.util.*;

class Solution {
    private static int n, w, h, res, maxTotal;
    private static int[] dr = {0, 0, -1, 1};
    private static int[] dc = {-1, 1, 0, 0};
    private static int[][] map;
    private static ArrayList<Integer> sequence;

    private static int[][] deepCopy() {
        int[][] next = new int[h][w];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                next[i][j] = map[i][j];
            }
        }
        return next;
    }

    private static boolean isRange(int r, int c) {
        return r >= 0 && c >= 0 && r < h && c < w;
    }

    private static int bfs(int[][] board, int r, int c, int weight) {
        int total = 0;
        Queue<int[]> qu = new LinkedList<>();
        qu.offer(new int[]{r, c, weight});
        board[r][c] = 0;

        while (!qu.isEmpty()) {
            int[] now = qu.poll();
            total++;

            for (int i = 0; i < 4; i++) {
                int nextR = now[0], nextC = now[1];
                for (int j = 1; j < now[2]; j++) {
                    nextR += dr[i];
                    nextC += dc[i];

                    if (!isRange(nextR, nextC)) break;

                    if (board[nextR][nextC] != 0) {
                        qu.offer(new int[]{nextR, nextC, board[nextR][nextC]});
                        board[nextR][nextC] = 0;
                    }
                }
            }
        }
        return total;
    }

    private static void downBlock(int[][] board) {
        for (int i = 0; i < w; i++) {
            int cur = h - 1;

            for (int j = cur; j >= 0; j--) {
                if (board[j][i] != 0) {
                    if (j == cur) cur--;
                    else {
                        board[cur--][i] = board[j][i];
                        board[j][i] = 0;
                    }
                }
            }
        }
    }

    private static int breakBlock() {
        int total = 0;
        int[][] board = deepCopy();

        for (int idx : sequence) {
            for (int i = 0; i < h; i++) {
                if (board[i][idx] != 0) {
                    total += bfs(board, i, idx, board[i][idx]);
                    downBlock(board);
                    break;
                }
            }
        }
        return total;
    }

    private static void combination(int cnt) {
        if (cnt == n) {
            int total = breakBlock();
            maxTotal = Math.max(maxTotal, total);
            return;
        }
        for (int i = 0; i < w; i++) {
            sequence.add(i);
            combination(cnt + 1);
            sequence.remove(cnt);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            res = 0;
            maxTotal = 0;
            sequence = new ArrayList<>();
            tokenizer = new StringTokenizer(br.readLine(), " ");

            n = Integer.parseInt(tokenizer.nextToken());
            w = Integer.parseInt(tokenizer.nextToken());
            h = Integer.parseInt(tokenizer.nextToken());
            map = new int[h][w];

            for (int i = 0; i < h; i++) {
                tokenizer = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(tokenizer.nextToken());

                    if (map[i][j] != 0) res++;
                }
            }
            combination(0);
            res -= maxTotal;
            System.out.println("#" + testCase + " " + res);
        } // end of testCase
    } // end of main
} // end of class
