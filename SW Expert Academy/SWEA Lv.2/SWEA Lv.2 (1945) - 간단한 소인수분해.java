import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        int[] primeFactor = {2, 3, 5, 7, 11};

        T = sc.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < primeFactor.length; i++) {
                int cnt = 0;

                while (N % primeFactor[i] == 0) {
                    cnt++;
                    N /= primeFactor[i];
                }
                sb.append(cnt + " ");
            }
            System.out.println("#" + testCase + " " + sb.toString());
        }
    }
}