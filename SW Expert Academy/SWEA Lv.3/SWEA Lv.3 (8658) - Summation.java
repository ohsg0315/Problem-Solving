import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            int resMax = Integer.MIN_VALUE, resMin = Integer.MAX_VALUE;

            int[] numArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i : numArr) {
                int buf = 0;

                do {
                    buf += i % 10;
                    i /= 10;
                } while (i != 0);
                resMax = Math.max(resMax, buf);
                resMin = Math.min(resMin, buf);
            }
            System.out.println("#" + testCase + " " + resMax + " " + resMin);
        }
    }
}