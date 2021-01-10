import java.io.*;
import java.util.*;

public class Main {
    private static class Assignment {
        int A, T;

        public Assignment(int A, int T) {
            this.A = A;
            this.T = T;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        Stack<Assignment> st = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        long score = 0;
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            int type = Integer.parseInt(tokenizer.nextToken());
            if (type == 1) {
                int A = Integer.parseInt(tokenizer.nextToken());
                int T = Integer.parseInt(tokenizer.nextToken()) - 1;
                if (T == 0) score += A;
                else st.push(new Assignment(A, T));
            } else if (type == 0 && !st.isEmpty()) {
                Assignment assignment = st.pop();
                assignment.T--;

                if (assignment.T == 0) score += assignment.A;
                else st.push(assignment);
            }
        }
        System.out.println(score);
    } // end of main
} // end of class