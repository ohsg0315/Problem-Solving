import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            String original = br.readLine();
            int res = 0, len = original.length();
            char now = original.charAt(0);
            boolean flag = false;

            for (int i = 0; i < len; i++) {
                if (i + 1 < len && now == original.charAt(i + 1)) {
                    continue;
                }

                if (now == '0') {
                    now = '1';
                    if (flag) {
                        res++;
                    }
                } else if (now == '1') {
                    now = '0';
                    res++;
                    flag = true;
                }
            }
            System.out.println("#" + testCase + " " + res);
        } // end of testCase
    } // end of main
} // end of class