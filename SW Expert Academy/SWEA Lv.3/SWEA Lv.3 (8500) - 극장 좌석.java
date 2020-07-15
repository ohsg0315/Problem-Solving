import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine()), minSeat = N, maxEmpty = -1;
            StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

            while (tokenizer.hasMoreTokens()) {
                int buf = Integer.parseInt(tokenizer.nextToken());

                maxEmpty = Math.max(maxEmpty, buf);
                minSeat += buf;
            }
            minSeat += maxEmpty;
            System.out.println("#" + testCase + " " + minSeat);
        }
    }
}