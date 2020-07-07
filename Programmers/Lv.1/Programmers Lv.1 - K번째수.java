import java.util.*;

public class Test {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for (int i = 0; i < commands.length; i++) {
			int[] buf = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
			Arrays.sort(buf);
			answer[i] = buf[commands[i][2] - 1];
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] a = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] b = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

		Test test = new Test();
		test.solution(a, b);
	}
}
