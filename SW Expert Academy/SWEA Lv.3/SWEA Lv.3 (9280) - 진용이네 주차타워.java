import java.util.*;

public class Solution {
    private static int findEmptySpace(int[] park) {
        int len = park.length;

        // 빈 자리 리턴
        for (int i = 1; i < len; i++) {
            if (park[i] == -1) {
                return i;
            }
        }
        // 자리 없음
        return -1;
    }

    private static int findCarPosition(int[] park, int car) {
        int len = park.length;

        // 주차된 차 위치 리턴
        for (int i = 1; i < len; i++) {
            if (park[i] == car) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt(), M = sc.nextInt(), res = 0;
            int[] park = new int[N + 1], charge = new int[N + 1], carWeight = new int[M + 1];
            Queue<Integer> sequence = new LinkedList<>(), wait = new LinkedList<>();

            // 주차 비용
            for (int i = 1; i <= N; i++) {
                park[i] = -1;
                charge[i] = sc.nextInt();
            }
            // 차 무게
            for (int i = 1; i <= M; i++) {
                carWeight[i] = sc.nextInt();
            }
            // 순서
            for (int i = 0; i < M * 2; i++) {
                sequence.offer(sc.nextInt());
            }

            while (!sequence.isEmpty()) {
                int pos, car;
                boolean input;

                // 다음 명령이 차량 들어옴 or 나감
                if (sequence.peek() > 0) {
                    input = true;
                } else {
                    input = false;
                }

                // 주차
                if (input) {
                    pos = findEmptySpace(park);

                    // 주차장 빈 곳이 있을 때
                    if (pos != -1) {
                        // 대기 차량이 없으면
                        if (wait.isEmpty()) {
                            park[pos] = sequence.poll();
                        }
                        // 대기 차량이 있으면
                        else {
                            park[pos] = wait.poll();
                        }
                    }
                    // 주차장 빈 곳이 없을 때
                    else {
                        wait.offer(sequence.poll());
                    }
                }
                // 차 나감
                else {
                    car = sequence.poll() * -1;
                    pos = findCarPosition(park, car);
                    res += charge[pos] * carWeight[car];

                    // 대기 차량이 없으면
                    if (wait.isEmpty()) {
                        park[pos] = -1;
                    }
                    // 대기 차량이 있으면 주
                    else {
                        park[pos] = wait.poll();
                    }
                }
            }

            System.out.println("#" + testCase + " " + res);
        }
    }
}