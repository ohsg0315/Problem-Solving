import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        HashMap<Integer, Integer> hm;

        for (int testCase = 1; testCase <= T; testCase++) {
            String res = "GAZUA";
            int N = sc.nextInt(), cur = 21, more = 0, less = 0;

            // 카드 세팅
            hm = new HashMap<>();
            for (int i = 2; i < 12; i++) {
                hm.put(i, 4);
            }
            hm.put(10, 16);

            // 덱에서 뽑은 카드 제거
            for (int i = 0; i < N; i++) {
                int buf = sc.nextInt();
                cur -= buf;
                hm.put(buf, hm.get(buf) - 1);
            }

            for (int i = 2; i < 12; i++) {
                if (i > cur) {
                    more += hm.get(i);
                } else {
                    less += hm.get(i);
                }
            }
            if (more >= less) {
                res = "STOP";
            }
            System.out.println("#" + testCase + " " + res);
        }
    }
}