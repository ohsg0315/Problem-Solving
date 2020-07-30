import java.util.*;
import java.io.*;

class Solution {
    private static boolean[] flag;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        StringBuilder sb;
        int T = 10;

        for (int testCase = 1; testCase <= T; testCase++) {
            int cnt = 0, before = 1;
            sb = new StringBuilder();
            br.readLine();
            tokenizer = new StringTokenizer(br.readLine(), " ");
            Queue<Integer> qu = new LinkedList<>();

            while (tokenizer.hasMoreTokens()) {
                qu.offer(Integer.parseInt(tokenizer.nextToken()));
            }
            while (before > 0) {
                cnt = (cnt % 5) + 1;
                int cur = qu.poll() - cnt;

                if (cur < 0) {
                    cur = 0;
                }
                qu.offer(cur);
                before = cur;
            }
            while (!qu.isEmpty()) {
                sb.append(qu.poll()).append(" ");
            }
            System.out.println("#" + testCase + " " + sb.toString());
        } // end of testCase
    } // end of main
} // end of class