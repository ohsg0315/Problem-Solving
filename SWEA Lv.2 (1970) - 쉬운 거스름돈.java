import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;

        T = sc.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};

            for (int i : money) {
                sb.append(N / i);
                sb.append(" ");
                N = N % i;
            }
            System.out.println("#" + testCase + "\n" + sb.toString());
        }
    }
}