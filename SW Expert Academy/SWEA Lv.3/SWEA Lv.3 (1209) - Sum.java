import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        for (int testCase = 1; testCase <= 10; testCase++) {
            int T = Integer.parseInt(br.readLine()), res = Integer.MIN_VALUE, total = 0;
            int[][] map = new int[100][100];

            // 입력 & 가로합
            for (int i = 0; i < 100; i++) {
                int cnt = 0;
                total = 0;
                tokenizer = new StringTokenizer(br.readLine(), " ");

                while (tokenizer.hasMoreTokens()) {
                    map[i][cnt] = Integer.parseInt(tokenizer.nextToken());
                    total += map[i][cnt++];
                }
                res = Math.max(res, total);
            }
            // 세로 합
            for (int i = 0; i < 100; i++) {
                total = 0;

                for (int j = 0; j < 100; j++) {
                    total += map[j][i];
                }
                res = Math.max(res, total);
            }
            // 대각
            total = 0;
            for (int i = 0, j = 0; i < 100; i++, j++) {
                total += map[i][j];
            }
            res = Math.max(res, total);
            System.out.println("#" + testCase + " " + res);
        }
    }
}