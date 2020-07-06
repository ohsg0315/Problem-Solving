import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;

        T = sc.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt();
            HashMap<Integer, Integer> hm = new HashMap<>();

            for (int i = 0; i < 1000; i++) {
                int buf = sc.nextInt();
                hm.put(buf, hm.getOrDefault(buf, 0) + 1);
            }

            int res = -1, maxNum = -1;
            for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
                if (entry.getValue() >= maxNum) {
                    maxNum = entry.getValue();
                    res = entry.getKey();
                }
            }
            System.out.println("#" + testCase + " " + res);
        }
    }
}