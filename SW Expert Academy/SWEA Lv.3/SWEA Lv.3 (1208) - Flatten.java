import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for (int testCase = 1; testCase <= T; testCase++) {
            int dump = sc.nextInt();
            int[] boxes = new int[100];

            // 박스 높이 입력
            for (int i = 0; i < 100; i++) {
                boxes[i] = sc.nextInt();
            }
            // 정렬 후 최솟값의 인덱스 = 0, 최댓값의 인덱스 = 99
            for (int i = 0; i < dump; i++) {
                Arrays.sort(boxes);
                boxes[0]++;
                boxes[99]--;
            }
            Arrays.sort(boxes);
            System.out.println("#" + testCase + " " + (boxes[99] - boxes[0]));
        }
    }
}