import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String exp = br.readLine();
        int len = exp.length();
        char key = exp.charAt(len - 1);
        Stack<Character> st = new Stack<>(), bufSt = new Stack<>();

        if (len > s.length()) {
            System.out.println(s);
            return;
        }

        for (int i = 0, length = s.length(); i < length; i++) {
            char c = s.charAt(i);

            // 폭발 문자열의 마지막 문자라면
            if (c == key && st.size() >= len - 1) {
                bufSt.push(c);

                // 폭발 문자열인지 검사
                for (int j = len - 2; j >= 0; j--) {
                    if (!st.isEmpty() && exp.charAt(j) == st.peek()) {
                        bufSt.push(st.pop());
                    }
                    // 폭발 문자열이 아니면 다시 집어넣는다.
                    else {
                        while (!bufSt.isEmpty()) {
                            st.push(bufSt.pop());
                        }
                        break;
                    }
                }
                // 폭발 문자열이면 스택 비움
                if (!bufSt.isEmpty()) {
                    bufSt.clear();
                }
            } else {
                st.push(c);
            }
        }


        // 남아있는 문자가 없는경우 or 남아있는 문자 출
        if (st.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            Iterator<Character> iter = st.iterator();
            while (iter.hasNext()) {
                sb.append(iter.next());
            }
            System.out.println(sb.toString());
        }
    } // end of main
} // end of class