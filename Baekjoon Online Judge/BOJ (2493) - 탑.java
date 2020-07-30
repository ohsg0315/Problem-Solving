import java.util.*;
import java.io.*;

public class Main {
    private static class Tower {
        int height, idx;

        Tower(int height, int idx) {
            this.height = height;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] res = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        Stack<Tower> st = new Stack<>();
        Tower[] towers = new Tower[N];

        for (int i = 0; i < N; i++) {
            towers[i] = new Tower(Integer.parseInt(tokenizer.nextToken()), i + 1);
        }

        st.push(towers[0]);
        for (int i = 1; i < N; i++) {
            int tower = towers[i].height;

            while (!st.isEmpty() && tower > st.peek().height) {
                st.pop();
            }
            if (!st.isEmpty() && st.peek().height >= tower) {
                res[i] = st.peek().idx;
            }
            st.push(towers[i]);
        }
        for (int i = 0; i < N; i++) {
            sb.append(res[i]).append(" ");
        }

        System.out.println(sb.toString().trim());
    } // end of main
} // end of class