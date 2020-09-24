import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        int t = Integer.parseInt(br.readLine());
        int[] list;

        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine()), len = 0;
            tokenizer = new StringTokenizer(br.readLine(), " ");
            list = new int[n + 1];
            list[0] = 0;

            for (int i = 0; i < n; i++) {
                int cur = Integer.parseInt(tokenizer.nextToken());

                if (list[len] >= cur) {
                    int idx = Arrays.binarySearch(list, 0, len, cur);
                    idx = idx < 0 ? -(idx + 1) : idx;
                    list[idx] = cur;
                } else {
                    list[++len] = cur;
                }
            }
            System.out.println("#" + testCase + " " + len);
        } // end of testCase
    } // end of main
} // end of class