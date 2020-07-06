import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;

        T = sc.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt(), speed = 0, dist = 0;

            for (int i = 0; i < N; i++) {
                int type = sc.nextInt();

                // 등속
                if (type == 0) {
                    dist += speed;
                } else {
                    int a = sc.nextInt();

                    // 가속
                    if (type == 1) {
                        speed += a;
                    }
                    // 감속
                    else if (type == 2) {
                        speed -= a;

                        if (speed < 0) {
                            speed = 0;
                        }
                    }
                    dist += speed;
                }
            }
            System.out.println("#" + testCase + " " + dist);
        }
    }
}