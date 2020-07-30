import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        int T = 10;

        for (int testCase = 1; testCase <= T; testCase++) {
            int size = Integer.parseInt(br.readLine()), res = 1;
            String bracket = br.readLine();
            flag = new boolean[4];
            Stack<Character> st = new Stack<>();

            for (int i = 0; i < size; i++) {
                char c = bracket.charAt(i);

                if (c == '{' || c == '[' || c == '(' || c == '<') {
                    st.push(c);
                } else {
                    if ((c == '}' && st.peek() == '{') || (c == ')' && st.peek() == '(') || (c == '>' && st.peek() == '<') || (c == ']' && st.peek() == '[')) {
                        st.pop();
                    } else {
                        res = 0;
                        break;
                    }
                }
            }
            System.out.println("#" + testCase + " " + res);
        } // end of testCase
    } // end of main
} // end of class