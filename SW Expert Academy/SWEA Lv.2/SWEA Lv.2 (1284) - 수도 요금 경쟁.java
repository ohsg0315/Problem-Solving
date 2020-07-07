import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;

        T = sc.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int P = sc.nextInt(), Q = sc.nextInt(), R = sc.nextInt(), S = sc.nextInt(), W = sc.nextInt();
            int priceA = P * W, priceB = Q;

            if (W <= R) {
                priceB = Q;
            } else {
                priceB = Q + (W - R) * S;
            }

            System.out.println("#" + testCase + " " + Math.min(priceA, priceB));
        }
    }
}