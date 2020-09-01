import java.util.*;
import java.io.*;

public class Main {
    private static int n, res;
    private static boolean flag;
    private static char[][] board;

    private static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < 10 && y < 10;
    }

    private static char[][] deepCopy(char[][] cur) {
        char[][] next = new char[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                next[i][j] = cur[i][j];
            }
        }
        return next;
    }

    private static boolean isPossible(char[][] map, int x, int y, int p) {
        for (int i = y; i < y + p; i++) {
            for (int j = x; j < x + p; j++) {
                if (map[i][j] == '0')
                    return false;
            }
        }
        return true;
    }

    private static void attatch(char[][] map, int x, int y, int p) {
        for (int i = y; i < y + p; i++) {
            for (int j = x; j < x + p; j++) {
                map[i][j] = '0';
            }
        }
    }

    private static void find(char[][] cur, int[] piece, int cnt, int rest) {
        if (cnt > res) return;

        if (rest == 0) {
            flag = true;
            if (res > cnt) res = cnt;
            return;
        }


        int x = 0, y = 0;
        label:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (cur[i][j] == '1') {
                    x = j;
                    y = i;
                    break label;
                }
            }
        }

        for (int p = 1; p <= 5; p++) {
            if (!isRange(x + p - 1, y + p - 1) || !isPossible(cur, x, y, p) || piece[p] == 0) continue;

            char[][] next = deepCopy(cur);
            int[] nextPiece = Arrays.copyOf(piece, 6);

            attatch(next, x, y, p);
            nextPiece[p]--;

            find(next, nextPiece, cnt + 1, rest - p * p);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        board = new char[10][10];

        for (int i = 0; i < 10; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 10; j++) {
                board[i][j] = tokenizer.nextToken().charAt(0);
                if (board[i][j] == '1') n++;
            }
        }
        res = Integer.MAX_VALUE;
        find(board, new int[]{5, 5, 5, 5, 5, 5}, 0, n);

        if (!flag) res = -1;
        System.out.println(res);
    } // end of main
} // end of class