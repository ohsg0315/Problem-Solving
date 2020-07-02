import java.util.*;

public class Test {
	public int[] solution(int[] answers) {
		int len = answers.length;
		int[] answer = {}, player = { 0, 0, 0 };
		int[][] pattern = { { 1, 2, 3, 4, 5 }, { 2, 1, 2, 3, 2, 4, 2, 5 }, { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 } };

		for (int i = 0; i < len; i++) {
			// 1번 수포자
			if (pattern[0][i % 5] == answers[i])
				player[0]++;

			// 2번 수포자
			if (pattern[1][i % 8] == answers[i])
				player[1]++;

			// 3번 수포자
			if (pattern[2][i % 10] == answers[i])
				player[2]++;
		}

		int cnt = 0, res = Math.max(player[0], Math.max(player[1], player[2]));
		for (int i = 0; i < 3; i++) {
			if (player[i] == res) {
				answer = Arrays.copyOf(answer, answer.length + 1);
				answer[cnt++] = i + 1;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] a = { 1, 3, 2, 4, 2 };
		Test test = new Test();
		System.out.println(test.solution(a));
	}
}
