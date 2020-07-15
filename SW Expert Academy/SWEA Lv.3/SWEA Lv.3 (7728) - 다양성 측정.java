import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            String number = br.readLine();
            Set<Integer> set = new HashSet<>();

            for (int i = 0; i < number.length(); i++) {
                set.add(number.charAt(i) - '0');
            }
            System.out.println("#" + testCase + " " + set.size());
        }
    }
}