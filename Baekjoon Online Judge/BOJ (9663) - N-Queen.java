import java.util.*;
import java.io.*;

public class Main {
    private static int N, res;
    private static int[] row;

    private static void backTracking(int cnt) {
        if (cnt == N) {
            res++;
            return;
        }
        for (int col = 0; col < N; col++) {
            boolean flag = true;
            row[cnt] = col;
            for (int i = 0; i < cnt; i++) {
                // 세로
                if (row[cnt] == row[i]) {
                    flag = false;
                    break;
                }
                // 대각선
                if (Math.abs(cnt - i) == Math.abs(row[i] - row[cnt])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                backTracking(cnt + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        row = new int[N];
        backTracking(0);
        System.out.println(res);
    } // end of main
} // end of class