import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            String validDate = sc.next(), res;
            String[] type = {"NA", "YYMM", "MMYY", "AMBIGUOUS"};
            int preDate = Integer.parseInt(validDate.substring(0, 2)), postDate = Integer.parseInt(validDate.substring(2));

            /*
             00인 경우를 생각하는 것이 중요하다!!
             preDate가 0 이거나 12 초과 = YY, postDate가 0 이거나 12 초과 = YY -> NA
             그 후에 preDate가 0 이거나 12 초과 -> YYMM
             그 후에 postDate가 0 이거나 12 초과 -> MMYY
             둘다 1 ~ 12 사이 라면 AMBIGUOUS
             */
            if ((preDate == 0 || preDate > 12) && (postDate == 0 || postDate > 12)) {
                res = type[0];
            } else if (preDate == 0 || preDate > 12) {
                res = type[1];
            } else if (postDate == 0 || postDate > 12) {
                res = type[2];
            } else {
                res = type[3];
            }
            System.out.println("#" + testCase + " " + res);
        }
    }
}