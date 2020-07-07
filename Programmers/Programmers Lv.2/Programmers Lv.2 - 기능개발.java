import java.util.*;

public class Test {
	public int[] solution(int[] progresses, int[] speeds) {
		int[] answer = { 1 };
		Queue<Integer> qu = new LinkedList<>();

		// process 작업일 계산 후 큐에 넣음
		for (int i = 0; i < progresses.length; i++) {
			int buf = 100 - progresses[i];
			qu.offer((int) Math.ceil(buf / (double) speeds[i]));
		}

		int buf = qu.poll(), cnt = 1;
		do {
			// 같은날 배포할 process 카운트
			if (qu.peek() <= buf) {
				cnt++;
				qu.poll();
			}
			// 다음날로 넘어가는 경우
			else {
				answer[answer.length - 1] = cnt;
				answer = Arrays.copyOf(answer, answer.length + 1);
				cnt = 1;
				buf = qu.poll();
			}
			// 큐 마지막인 경우
			if (qu.isEmpty()) {
				answer[answer.length - 1] = cnt;
			}
		} while (!qu.isEmpty());
		return answer;
	}

	public static void main(String[] args) {
		Test test = new Test();
	}
}
