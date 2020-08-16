import java.util.*;
import java.io.*;

public class Main {
    private static int resPin, resCnt;
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};

    private static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < 9 && y < 5;
    }

    private static char[][] deepCopy(char[][] cur) {
        char[][] next = new char[5][9];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                next[i][j] = cur[i][j];
            }
        }
        return next;
    }

    private static void findMin(char[][] cur, int pin, int cnt) {
        if (pin == resPin && cnt < resCnt) {
            resCnt = cnt;
        }
        if (pin < resPin) {
            resPin = pin;
            resCnt = cnt;
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (cur[i][j] == 'o') {
                    for (int k = 0; k < 4; k++) {
                        int x = j + dx[k];
                        int y = i + dy[k];

                        if (!isRange(x, y)) continue;
                        if (cur[y][x] == 'o' && isRange(x + dx[k], y + dy[k]) && cur[y + dy[k]][x + dx[k]] == '.') {
                            char[][] next = deepCopy(cur);
                            next[i][j] = '.';
                            next[i + dy[k]][j + dx[k]] = '.';
                            next[i + 2 * dy[k]][j + 2 * dx[k]] = 'o';

                            findMin(next, pin - 1, cnt + 1);
                        }
                    }
                } // find pin
            } // search Board
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            resPin = 0;
            resCnt = Integer.MAX_VALUE;
            char[][] board = new char[5][9];
            for (int i = 0; i < 5; i++) {
                String buf = br.readLine();
                for (int j = 0; j < 9; j++) {
                    board[i][j] = buf.charAt(j);
                    if (board[i][j] == 'o') {
                        resPin++;
                    }
                }
            } // end of input
            findMin(board, resPin, 0);
            sb.append(resPin).append(' ').append(resCnt).append('\n');
            if (t != 0) {
                br.readLine();
            }
        } // end of while
        System.out.print(sb.toString());
    } // end of main
} // end of class