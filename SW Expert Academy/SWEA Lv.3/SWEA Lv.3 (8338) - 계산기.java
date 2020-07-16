import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            int res = Integer.MIN_VALUE, N = Integer.parseInt(br.readLine());
            int[] numArr = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();


            for (int num : numArr) {
                if (res == Integer.MIN_VALUE) {
                    res = num;
                    continue;
                }
                res = Math.max(res + num, res * num);
            }
            System.out.println("#" + testCase + " " + res);
        }
    }
}