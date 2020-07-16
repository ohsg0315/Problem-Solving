import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            int res = 0;
            int[] condition = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            int[] sandWatch = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

            for (int buf : sandWatch) {
                for (int i = condition[1] - condition[2]; i <= condition[1] + condition[2]; i++) {
                    if (i % buf == 0) {
                        res++;
                        break;
                    }
                }
            }
            System.out.println("#" + testCase + " " + res);
        }
    }
}