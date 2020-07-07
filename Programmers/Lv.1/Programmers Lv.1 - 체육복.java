import java.util.*;

public class Test {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		int[] status = new int[n];

		// 학생 체육복 = 1
		Arrays.fill(status, 1);

		// 도난당한 학생
		for (int i : lost) {
			status[i - 1]--;
		}
		// 여벌 체육복이 있는 학생
		for (int i : reserve) {
			status[i - 1]++;
		}

		for (int i = 0; i < n; i++) {
			// 도난 당했을 때 양 옆번호에 여벌이 있다면 빌려 줌 (왼쪽 우선)
			if (status[i] == 0) {
				// 왼쪽
				if (i != 0 && status[i - 1] == 2) {
					status[i - 1]--;
					status[i]++;
				}
				// 오른쪽
				else if (i != n - 1 && status[i + 1] == 2) {
					status[i + 1]--;
					status[i]++;
				}
			}
		}

		// 수업을 들을 수 있는 학생 수
		for (int i : status) {
			if (i != 0)
				answer++;
		}
		return answer;
	}

	public static void main(String[] args) {
		Test test = new Test();
		test.solution(5, new int[] { 2, 4 }, new int[] { 1, 3, 5 });
	}
}
