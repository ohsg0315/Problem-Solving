import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            String[] bufString = br.readLine().split("\\s");
            int N = Integer.parseInt(bufString[0]), K = Integer.parseInt(bufString[1]), total = N * K;
            int[] team = new int[K];
            StringBuilder sb = new StringBuilder();
            boolean turn = true;

            for (int i = 1; i <= total; i += K) {
                if (turn) {
                    int bufNum = 0;

                    for (int j = i; j < i + K; j++) {
                        team[bufNum++] += j;
                    }
                    turn = false;
                } else {
                    int bufNum = K - 1;

                    for (int j = i; j < i + K; j++) {
                        team[bufNum--] += j;
                    }
                    turn = true;
                }
            }


            for (int i = 0; i < K; i++) {
                sb.append(team[i] + " ");
            }
            System.out.println("#" + testCase + " " + sb.toString());
        }
    }
}