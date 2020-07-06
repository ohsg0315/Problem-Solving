import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;

        T = sc.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt(), cnt = 0;
            StringBuilder sb = new StringBuilder();

            sb.append("#" + testCase + "\n");

            for (int i = 0; i < N; i++) {
                String alpha = sc.next();
                int num = sc.nextInt();

                for (int j = 0; j < num; j++) {
                    if (cnt == 10) {
                        cnt = 0;
                        sb.append("\n");
                    }
                    sb.append(alpha);
                    cnt++;
                }
            }
            System.out.println(sb.toString());
        }
    }
}