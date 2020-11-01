import java.io.*;
import java.util.*;

class Solution {
    private static int res;
    private static int[] price, month;

    private static void dfs(int cnt, int total) {
        if(cnt >= 12){
            res = Math.min(res, total);
            return;
        }
        if(month[cnt] == 0) dfs(cnt + 1, total);

        // 1일 이용권
       dfs(cnt + 1, total + month[cnt] * price[0]);

       // 1달 이용권
       dfs(cnt + 1, total + price[1]);

       // 3달 이용권
       dfs(cnt + 3, total + price[2]);

       // 1년 이용권
       dfs(cnt + 12, total + price[3]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            res = Integer.MAX_VALUE;
            price = new int[4];
            month = new int[12];
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < 4; i++) {
                price[i] = Integer.parseInt(tokenizer.nextToken());
            }
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < 12; i++) {
                month[i] = Integer.parseInt(tokenizer.nextToken());
            }

            dfs(0, 0);
            System.out.println("#" + testCase + " " + res);
        } // end of testCase
    } // end of main
} // end of class
