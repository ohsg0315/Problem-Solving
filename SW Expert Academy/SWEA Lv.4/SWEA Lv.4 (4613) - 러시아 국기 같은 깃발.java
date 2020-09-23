import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(tokenizer.nextToken());
            int m = Integer.parseInt(tokenizer.nextToken());
            int[][] cache = new int[n][3], color = new int[n][3];
            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                for (int j = 0; j < m; j++) {
                    char c = s.charAt(j);
                    switch (c) {
                        case 'W':
                            color[i][0]++;
                            break;
                        case 'B':
                            color[i][1]++;
                            break;
                        case 'R':
                            color[i][2]++;
                            break;
                    }
                }
            } // end of input
            cache[0][0] = color[0][1] + color[0][2]; // 첫번째 라인은 흰색
            cache[0][1] = n * m;
            cache[0][2] = n * m;

            for (int i = 1; i < n; i++) {
                cache[i][0] = cache[i - 1][0] + color[i][1] + color[i][2];
                cache[i][1] = Math.min(cache[i - 1][0], cache[i - 1][1]) + color[i][0] + color[i][2];
                cache[i][2] = Math.min(cache[i - 1][1], cache[i - 1][2]) + color[i][0] + color[i][1];
            }
            System.out.println("#" + testCase + " " + cache[n - 1][2]);
        } // end of testCase
    } // end of main
} // end of class