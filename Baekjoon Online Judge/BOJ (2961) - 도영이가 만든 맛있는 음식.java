import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static long res = Long.MAX_VALUE;
    private static long[][] taste;

    private static void dfs(long sour, long bitter, int idx) {
        // 재료를 하나도 사용하지 않은 경우
        if (idx == n && sour == 1 && bitter == 0) {
            return;
        }
        if (idx == n) {
            long cur = Math.abs(sour - bitter);
            if (cur < res) {
                res = cur;
            }
            return;
        }
        // 음식 추가
        dfs(sour * taste[idx][0], bitter + taste[idx][1], idx + 1);

        // 음식 제외
        dfs(sour, bitter, idx + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        n = Integer.parseInt(br.readLine());
        taste = new long[n][2];

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine());

            taste[i][0] = Long.parseLong(tokenizer.nextToken());
            taste[i][1] = Long.parseLong(tokenizer.nextToken());
        }

        dfs(1, 0, 0);
        System.out.println(res);
    } // end of main
} // end of class