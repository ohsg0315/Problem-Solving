import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt();

            /*
            중복된 값이 있다 -> 순열 생성 불가능 (중복 순열이 아니기 때문)
            Set에 값을 넣고 size를 비교한다.
            */
            HashSet<Integer> hs = new HashSet<>();
            for (int i = 0; i < N; i++) {
                hs.add(sc.nextInt());
            }

            if (hs.size() == N) {
                System.out.println("#" + testCase + " Yes");
            } else {
                System.out.println("#" + testCase + " No");
            }
        }
    }
}