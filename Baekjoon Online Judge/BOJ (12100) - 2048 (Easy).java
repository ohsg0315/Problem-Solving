import java.util.*;
import java.io.*;

public class Main {
    private static int n, maxNumber;
    private static int[][] board;
    private static Deque<Integer> dq;

    private static int[][] rotate(int[][] cur) {
        int[][] next = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                next[i][j] = cur[n - 1 - j][i];
            }
        }
        return next;
    }

    private static void dfs(int[][] cur, int cnt) {
        for (int i = 0; i < 4; i++) {
            cur = rotate(cur);
            int[][] next = new int[n][n];

            for (int y = 0; y < n; y++) {
                int idx = 0;
                for (int x = 0; x < n; x++) {
                    if (cur[y][x] == 0) continue;
                    // 합쳐지는 경우
                    if (!dq.isEmpty() && dq.peekLast() == cur[y][x]) {
                        dq.offer(dq.pollLast() * 2);

                        while (!dq.isEmpty()) {
                            next[y][idx++] = dq.pollFirst();

                            maxNumber = Math.max(maxNumber, next[y][idx - 1]);
                        }
                    } else {
                        dq.offer(cur[y][x]);
                    }
                }
                while (!dq.isEmpty()) {
                    next[y][idx++] = dq.pollFirst();
                    maxNumber = Math.max(maxNumber, next[y][idx - 1]);
                }
            } // end of move for
            if (cnt + 1 != 5) {
                dfs(next, cnt + 1);
            }
        } // end of rotate for
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        dfs(board, 0);
        System.out.println(maxNumber);
    } // end of main
} // end of class