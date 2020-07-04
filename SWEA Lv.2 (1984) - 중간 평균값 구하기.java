import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            int sum = 0, maxNum = -1, minNum = -1;
            int[] numbers = new int[10];

            for (int i = 0; i < 10; i++) {
                numbers[i] = sc.nextInt();
                maxNum = Math.max(maxNum, numbers[i]);
                minNum = Math.min(minNum, numbers[i]);
            }
            Arrays.sort(numbers);
            for (int i = 1 ; i < 9; i++) {
                sum += numbers[i];
            }
            sum = (int) Math.round(sum / (double) 8);
            System.out.println("#" + testCase + " " + sum);
        }
    }
}
