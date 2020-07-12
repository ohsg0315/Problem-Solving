import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            int K = sc.nextInt(), res = 0;
            Stack<Integer> st = new Stack<>();

            for (int i = 0; i < K; i++) {
                int buf = sc.nextInt();

                if (buf == 0) {
                    st.pop();
                } else {
                    st.push(buf);
                }
            }
            while (!st.isEmpty()) {
                res += st.pop();
            }
            System.out.println("#" + testCase + " " + res);
        }
    }
}