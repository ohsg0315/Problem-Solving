import java.util.*;
import java.io.*;

public class Solution {
    public String solution(String p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder u = new StringBuilder(), v = new StringBuilder();

        // 1.
        if (p.length() == 0) return "";

        // 2.
        int idx = 0, open = 0, close = 0;
        while (true) {
            if (open != 0 && open == close) break;

            if (p.charAt(idx) == '(') open++;
            else if (p.charAt(idx) == ')') close++;
            u.append(p.charAt(idx++));
        }
        v.append(p.substring(idx));

        // 3.
        Stack<Character> st = new Stack<>();
        for (int i = 0, length = u.length(); i < length; i++) {
            if (!st.isEmpty() && st.peek() == '(' && u.charAt(i) == ')') st.pop();
            else st.push(u.charAt(i));
        }
        // 3-1.
        if (st.isEmpty()) return answer.append(u.toString()).append(solution(v.toString())).toString();

            // 4.
        else {
            // 4-1.
            answer.append('(');

            // 4-2.
            answer.append(solution(v.toString()));

            // 4-3.
            answer.append(')');

            // 4-4.
            String s = u.substring(1, u.length() - 1);
            for (int i = 0, length = s.length(); i < length; i++) {
                if (s.charAt(i) == '(') answer.append(')');
                else answer.append('(');
            }
        }
        return answer.toString();
    }

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        System.out.println(s.solution(")("));
    } // end of main
} // end of class