import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;

        T = sc.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int[][] time = new int[2][2];

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    time[i][j] = sc.nextInt();
                }
            }

            time[0][0] += time[1][0];
            time[0][1] += time[1][1];

            if (time[0][1] >= 60) {
                time[0][1] -= 60;
                time[0][0] += 1;
            }
            if (time[0][0] > 12) {
                time[0][0] -= 12;
            }

            System.out.println("#" + testCase + " " + time[0][0] + " " + time[0][1]);
        }
    }
}
