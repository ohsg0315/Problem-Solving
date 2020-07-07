import java.util.*;

public class Test {
	public int[] solution(int[] arr) {
		int buf = -1, len = 0;
		int[] answer = new int[arr.length];

		for (int i : arr) {
			// 같으면 통과
			if (buf == i) {
				continue;
			}
			// 다르면 answer 배열에 추가
			else {
				buf = i;
				answer[len++] = i;
			}
		}
		// 배열 크기 줄이기
		return Arrays.copyOfRange(answer, 0, len);
	}

	public static void main(String[] args) {
		Test test = new Test();
		System.out.println(test.solution(new int[] { 1, 1, 3, 3, 0, 1, 1, 3 }));
	}
}
