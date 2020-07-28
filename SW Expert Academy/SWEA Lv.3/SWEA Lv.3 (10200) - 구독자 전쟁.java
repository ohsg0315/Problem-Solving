import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(tokenizer.nextToken());
            int p = Integer.parseInt(tokenizer.nextToken());
            int t = Integer.parseInt(tokenizer.nextToken());

            int maxNum = Math.min(p, t);
            int minNum = ((p + t) > N) ? (p + t - N) : 0;

            System.out.println("#" + testCase + " " + maxNum + " " + minNum);
        } // end of testCase
    } // end of main
} // end of class