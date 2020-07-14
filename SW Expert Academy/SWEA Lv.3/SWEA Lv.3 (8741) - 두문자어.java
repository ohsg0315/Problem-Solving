import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            StringBuilder sb = new StringBuilder();
            StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; tokenizer.hasMoreTokens(); i++) {
                sb.append(tokenizer.nextToken().toUpperCase().charAt(0));
            }

            System.out.println("#" + testCase + " " + sb.toString());
        }
    }
}