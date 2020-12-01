import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long res = 0;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(br.readLine());

            while (!st.isEmpty() && st.peek() <= now) {
                st.pop();
            }
            res += st.size();
            st.push(now);
        }
        System.out.println(res);
    } // end of main
}