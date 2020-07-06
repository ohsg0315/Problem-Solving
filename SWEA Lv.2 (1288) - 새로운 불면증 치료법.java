import java.util.*;

public class Solution {
    private static boolean isFinish(int[] numbers) {
        for (int number : numbers) {
            if (number == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;

        T = sc.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt(), nextN = N, res = 0;
            int[] numbers = new int[10];

            while (!isFinish(numbers)) {
                int buf = nextN;
                while (buf != 0) {
                    int number = buf % 10;
                    numbers[number]++;
                    buf /= 10;
                }
                res++;
                nextN = N * (res + 1);
            }
            res *= N;
            System.out.println("#" + testCase + " " + res);
        }
    }
}