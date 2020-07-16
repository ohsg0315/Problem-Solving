import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            long N = Long.parseLong(br.readLine());
            long a = 1, l = a + (N - 1) * 2, totalNum = N * (a + l) / 2;

            long first = 1, last = 1 + (totalNum - 1) * 2;

            if (N != 1) {
                first = last - (2 * (N - 1)) * 2;
            }
            System.out.println("#" + testCase + " " + first + " " + last);
        }
    }
}