import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            double p = sc.nextDouble(), q = sc.nextDouble();
            double s1, s2;


            // 한 번 뒤집는 경우 : 반대로 - 올바르게
            // 뒤집어 꽂는다 (1 - p) - 뒤집는다 - 들어간다 (q)
            s1 = (1 - p) * q;

            // 두 번 뒤집는 경우 : 올바르게 - 반대 - 올바르게
            // 올바르게 꽂는다 (p) -> 실패한다 (1 - q) - 뒤집는다 - 반대 - 뒤집는다 - 성공(q)
            s2 = p * (1 - q) * q;

            if(s1 < s2) {
                System.out.println("#" + testCase + " YES");
            }else{
                System.out.println("#" + testCase + " NO");
            }

        }
    }
}