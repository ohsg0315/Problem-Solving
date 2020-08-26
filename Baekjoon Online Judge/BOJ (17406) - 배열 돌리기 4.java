import java.util.*;
import java.io.*;

public class Main {
    private static int n, m, k, res;
    private static int[] order;
    private static int[][] arr;
    private static boolean[] isSelected;
    private static ArrayList<Command> list;

    private static class Command {
        int r, c, s;

        public Command(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }

    private static int[][] deepCopy(int[][] cur) {
        int[][] next = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                next[i][j] = cur[i][j];
            }
        }
        return next;
    }

    private static int[][] rotate(int[][] cur, int r, int c, int s) {
        int[][] next = deepCopy(cur);

        while (s > 0) {
            int startC = c - s, endC = c + s;
            int startR = r - s, endR = r + s;

            int temp = cur[startR][startC];
            // 왼쪽 위
            for (int i = startR; i < endR; i++) {
                next[i][startC] = next[i + 1][startC];
            }
            // 하단 오른쪽 <-
            for (int i = startC; i < endC; i++) {
                next[endR][i] = next[endR][i + 1];
            }
            // 오른쪽 아래
            for (int i = endR; i > startR; i--) {
                next[i][endC] = next[i - 1][endC];
            }
            // 상단 왼쪽 ->
            for (int i = endC; i > startC; i--) {
                next[startR][i] = next[startR][i - 1];
            }
            next[startR][startC + 1] = temp;
            s--;
        }
        return next;
    }

    private static void permutation(int cnt) {
        if (cnt == k) {
            int[][] cur = deepCopy(arr);
            for (int i = 0; i < k; i++) {
                Command c = list.get(order[i]);
                cur = rotate(cur, c.r, c.c, c.s);
            }
            for (int i = 0; i < n; i++) {
                int total = 0;
                for (int j = 0; j < m; j++) {
                    total += cur[i][j];
                }
                if (total < res) res = total;
            }
            return;
        }
        for (int i = 0; i < k; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                order[cnt] = i;
                permutation(cnt + 1);

                isSelected[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        k = Integer.parseInt(tokenizer.nextToken());
        res = Integer.MAX_VALUE;
        order = new int[k];
        isSelected = new boolean[k];
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(tokenizer.nextToken()) - 1;
            int c = Integer.parseInt(tokenizer.nextToken()) - 1;
            int s = Integer.parseInt(tokenizer.nextToken());

            list.add(new Command(r, c, s));
        }
        permutation(0);
        System.out.println(res);
    } // end of main
} // end of class