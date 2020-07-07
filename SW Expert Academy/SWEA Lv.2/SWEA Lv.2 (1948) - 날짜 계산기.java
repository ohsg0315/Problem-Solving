import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        T = sc.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int firstMonth = sc.nextInt() - 1, firstDay = sc.nextInt();
            int secondMonth = sc.nextInt() - 1, secondDay = sc.nextInt();

            int diffDay = secondDay + 1;
            for (int i = 0; i < secondMonth; i++) {
                diffDay += month[i];
            }

            diffDay -= firstDay;
            for (int i = 0; i < firstMonth; i++) {
                diffDay -= month[i];
            }

            System.out.println("#" + testCase + " " + diffDay);
        }
    }
}