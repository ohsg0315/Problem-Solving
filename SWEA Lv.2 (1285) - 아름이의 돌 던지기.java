/*
    SWEA에 C++만 제출 가능 -> Input.txt, Output.txt 값만 확인한 코드
*/

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;

        T = sc.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt();
            TreeMap<Integer, Integer> tm = new TreeMap<>();

            // 트리맵에 추가하며정렬 -> 최솟값이 상단에 있다
            for (int i = 0; i < N; i++) {
                int buf = sc.nextInt();

                tm.put(Math.abs(buf), tm.getOrDefault(Math.abs(buf), 0) + 1);
            }
            // 상단 = 최솟값
            for (Map.Entry<Integer, Integer> entry : tm.entrySet()) {
                // 출력
                System.out.println("#" + testCase + " " + entry.getKey() + " " + entry.getValue());
                break;
            }

        }
    }
}