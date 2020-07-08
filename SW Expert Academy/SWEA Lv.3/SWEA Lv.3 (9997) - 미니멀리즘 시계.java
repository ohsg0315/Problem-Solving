import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            int degree = sc.nextInt();

            // 시침 => 360도 : 7200분 => 1도 : 2분
            int hour = degree / 30, minute = (degree % 30) * 2;
            System.out.println("#" + testCase + " " + hour + " " + minute);
        }
    }
}