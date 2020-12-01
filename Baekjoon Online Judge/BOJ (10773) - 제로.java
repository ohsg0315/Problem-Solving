import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> st = new Stack<>();
        int k = Integer.parseInt(br.readLine()), res = 0;

        for (int i = 0; i < k; i++) {
            int buf = Integer.parseInt(br.readLine());
            if (buf != 0)
                st.add(buf);
            else
                st.pop();
        }
        while (!st.isEmpty()) {
            res += st.pop();
        }
        System.out.println(res);
    } // end of main
}