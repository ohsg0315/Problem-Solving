import java.util.*;
import java.io.*;

public class Main {
    private static int len;
    private static int[] flag;
    private static ArrayList<Character> original;
    private static ArrayList<String> res;
    private static StringBuilder sb;

    private static void backTracking(String s, int idx) {
        // 문자열 끝에 도달하면 종료
        if (idx == len) {
            res.add(s);
            return;
        }

        // 괄호가 아니면 스트링에 추가
        sb.delete(0, sb.length());
        while (original.get(idx) != '(' && original.get(idx) != ')') {
            sb.append(original.get(idx));
            if (++idx == len) {
                break;
            }
        }
        s += sb.toString();

        // 문자열 끝에 도달했다면 종료
        if (idx == len) {
            backTracking(s, idx);
            return;
        }

        // 열린 괄호
        if (original.get(idx) == '(') {
            // 괄호 제거
            flag[idx] = 1;
            backTracking(s, idx + 1);

            // 괄호 제거 X
            flag[idx] = -1;
            backTracking(s + original.get(idx), idx + 1);
        }
        // 닫힌 괄호
        else if (original.get(idx) == ')') {
            // 앞에 열린괄호 뺀적이 있다면 빼거나 안 뺀다.
            if (flag[flag[idx]] == 1) {
                // 괄호 제거
                backTracking(s, idx + 1);
            }
            // 괄호 제거 X
            else if (flag[flag[idx]] == -1) {
                backTracking(s + original.get(idx), idx + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Integer> st = new Stack<>();
        original = new ArrayList<>();
        res = new ArrayList<>();
        flag = new int[201];
        len = s.length();
        sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            original.add(s.charAt(i));

            if (original.get(i) == '(') {
                st.push(i);
            } else if (original.get(i) == ')') {
                flag[i] = st.pop();
            }
        }

        backTracking("", 0);
        res.remove(s);

        TreeSet<String> ts = new TreeSet<>();
        for (int i = 0, length = res.size(); i < length; i++) {
            ts.add(res.get(i));
        }
        Iterator<String> iter = ts.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    } // end of main
} // end of class