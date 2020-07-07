import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] grade = {"D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+"};
        int T;

        T = sc.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt(), K = sc.nextInt(), duplication = N / 10;
            double[][] students = new double[N][4];
            TreeMap<Double, Integer> tm = new TreeMap<>();

            // 총점 계산 후 TreeMap에 저장
            for (int i = 0; i < N; i++) {
                students[i][0] = sc.nextDouble();
                students[i][1] = sc.nextDouble();
                students[i][2] = sc.nextDouble();
                students[i][3] = students[i][0] * 0.35 + students[i][1] * 0.45 + students[i][2] * 0.2;

                tm.put(students[i][3], i + 1);
            }

            // TreeMap에서 꺼내며 확인
            int cnt = 0;
            Set<Map.Entry<Double, Integer>> entries = tm.entrySet();
            for (Map.Entry<Double, Integer> entry : entries) {
                if(entry.getValue() == K) {
                    System.out.println("#" + testCase + " " + grade[cnt / duplication]);
                    break;
                }
                cnt++;
            }
        }
    }
}
