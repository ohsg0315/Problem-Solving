import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int res = 0;
        String s = br.readLine();
        Stack<String> st = new Stack<>();

        for (int i = 0, length = s.length(); i < length; i++) {
            String c = s.charAt(i) + "";

            // 33a(562a(71a(9)))
            if (c.equals("(")) {
                String buf = st.pop() + "a";
                st.push(buf);
                st.push(c);
            } else if (c.equals(")")) {
                int num = 0;

                while (!st.peek().equals("(")) {
                    int len = st.peek().length();

                    if (st.peek().charAt(len - 1) == 'b') {
                        num += Integer.parseInt(st.peek().substring(0, len - 1));
                    } else {
                        num++;
                    }
                    st.pop();
                }
                st.pop();
                String buf = st.pop();
                int cnt = Integer.parseInt(buf.substring(0, buf.length() - 1));
                num *= cnt;
                st.push(num + "b");
            } else {
                st.push(c);
            }
        }
        while (!st.isEmpty()) {
            String buf = st.pop();
            int len = buf.length();
            if (buf.charAt(len - 1) == 'b') {
                res += Integer.parseInt(buf.substring(0, len - 1));
            } else {
                res++;
            }
        }
        System.out.println(res);
    } // end of main
} // end of class