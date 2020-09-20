import java.util.*;
import java.io.*;

public class Main {
    private static int[][] board;
    private static boolean[][] selected;

    private static void find(int num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == num) {
                    selected[i][j] = true;
                    return;
                }
            }
        }
    }

    private static boolean isFinish() {
        int cnt = 0;
        boolean flag;

        for (int i = 0; i < 5; i++) {
            flag = true;
            for (int j = 0; j < 5; j++) {
                if (!selected[i][j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) cnt++;
        }
        if (cnt >= 3) return true;

        for (int i = 0; i < 5; i++) {
            flag = true;
            for (int j = 0; j < 5; j++) {
                if (!selected[j][i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) cnt++;
        }
        if (cnt >= 3) return true;

        flag = true;
        for (int i = 0; i < 5; i++) {
            if (!selected[i][i]) {
                flag = false;
                break;
            }
        }
        if (flag) cnt++;
        if (cnt >= 3) return true;

        flag = true;
        for (int i = 0; i < 5; i++) {
            if (!selected[4 - i][i]) {
                flag = false;
                break;
            }
        }
        if (flag) cnt++;
        return cnt >= 3;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        board = new int[5][5];
        selected = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        int cnt = 0;
        label:
        for (int i = 0; i < 5; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                cnt++;
                int cur = Integer.parseInt(tokenizer.nextToken());

                find(cur);
                if (i > 0 && isFinish()) break label;
            }
        }
        System.out.println(cnt);
    } // end of main
} // end of class