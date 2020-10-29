import java.io.*;
import java.util.*;

class Solution {
    private static int N;
    private static int[][] board, res;

    private static void move(String command) {
        int cur, cnt;
        Deque<Integer> dq = new ArrayDeque<>();

        if ("up".equals(command)) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    cur = board[j][i];
                    if (cur == 0) continue;

                    if (!dq.isEmpty() && dq.peekLast() == cur) {
                        dq.offerLast(dq.pollLast() * 2);
                        dq.offerLast(0);
                    } else
                        dq.offerLast(cur);
                }
                cnt = 0;
                while (!dq.isEmpty()) {
                    if (dq.peekFirst() == 0) {
                        dq.pollFirst();
                    } else {
                        res[cnt++][i] = dq.pollFirst();
                    }
                }
            }
        } else if ("down".equals(command)) {
            for (int i = 0; i < N; i++) {
                for (int j = N - 1; j >= 0; j--) {
                    cur = board[j][i];
                    if (cur == 0) continue;

                    if (!dq.isEmpty() && dq.peekLast() == cur) {
                        dq.offerLast(dq.pollLast() * 2);
                        dq.offerLast(0);
                    } else
                        dq.offerLast(cur);
                }
                cnt = N - 1;
                while (!dq.isEmpty()) {
                    if (dq.peekFirst() == 0) {
                        dq.pollFirst();
                    } else {
                        res[cnt--][i] = dq.pollFirst();
                    }
                }
            }
        } else if ("right".equals(command)) {
            for (int i = 0; i < N; i++) {
                for (int j = N - 1; j >= 0; j--) {
                    cur = board[i][j];
                    if (cur == 0) continue;

                    if (!dq.isEmpty() && dq.peekLast() == cur) {
                        dq.offerLast(dq.pollLast() * 2);
                        dq.offerLast(0);
                    } else
                        dq.offerLast(cur);
                }
                cnt = N - 1;
                while (!dq.isEmpty()) {
                    if (dq.peekFirst() == 0) {
                        dq.pollFirst();
                    } else {
                        res[i][cnt--] = dq.pollFirst();
                    }
                }
            }
        } else if ("left".equals(command)) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    cur = board[i][j];
                    if (cur == 0) continue;

                    if (!dq.isEmpty() && dq.peekLast() == cur) {
                        dq.offerLast(dq.pollLast() * 2);
                        dq.offerLast(0);
                    } else
                        dq.offerLast(cur);
                }
                cnt = 0;
                while (!dq.isEmpty()) {
                    if (dq.peekFirst() == 0) {
                        dq.pollFirst();
                    } else {
                        res[i][cnt++] = dq.pollFirst();
                    }
                }
            }
        }
    } // end of method

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(tokenizer.nextToken());
            String command = tokenizer.nextToken();
            res = new int[N][N];
            board = new int[N][N];
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < N; i++) {
                tokenizer = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }
            move(command);
            System.out.println("#" + testCase);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(res[i][j]).append(' ');
                }
                sb.setCharAt(sb.length() - 1, '\n');
            }
            System.out.print(sb.toString());
        } // end of testCase
    } // end of main
} // end of class
