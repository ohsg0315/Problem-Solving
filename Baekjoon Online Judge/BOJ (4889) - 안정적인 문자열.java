import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int res, cnt = 1;
        Stack<Character> st = new Stack<>();

        while (true) {
            res = 0;
            String s = br.readLine();
            int length = s.length();

            if (s.charAt(0) == '-') break;

            for (int i = 0; i < length; i++) {
                if (!st.isEmpty() && st.peek() == '{' && s.charAt(i) == '}') {
                    st.pop();
                } else {
                    st.push(s.charAt(i));
                }
            }
            while (!st.isEmpty()) {
                char c = st.pop();
                if (c == '{')
                    res++;

                if (st.peek() == '}')
                    res++;

                st.pop();
            }
            sb.append(cnt++).append('.').append(' ').append(res).append('\n');
        }
        System.out.print(sb.toString());
    } // end of main
}