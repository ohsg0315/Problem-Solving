import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();

        while (T-- > 0) {
            st.clear();
            String s = br.readLine();

            for (int i = 0, length = s.length(); i < length; i++) {
                char c = s.charAt(i);
                if (st.isEmpty()) {
                    st.push(c);
                } else if (c == ')' && st.peek() == '(') {
                    st.pop();
                } else {
                    st.push(c);
                }
            }
            if (st.isEmpty()) sb.append("YES").append('\n');
            else sb.append("NO").append('\n');
        }
        System.out.print(sb.toString());
    } // end of main
}