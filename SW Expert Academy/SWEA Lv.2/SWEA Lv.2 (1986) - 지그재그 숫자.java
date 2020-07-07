import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;

		T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int oddNum, evenNum;

			// 등차수열의 합 = N * (2a + (n - 1)d) / 2

			// N이 짝수 -> 홀수, 짝수의 갯수가 같음. -> N / 2 개
			if (N % 2 == 0) {
				N /= 2;
				oddNum = N * (2 + (N - 1) * 2) / 2;
				evenNum = N * (2 * 2 + (N - 1) * 2) / 2;
			}
			// N이 홀수 -> 홀수는 N / 2 + 1개, 짝수는 N / 2 개
			else {
				N /= 2;
				oddNum = (N + 1) * (2 + N * 2) / 2;
				evenNum = N * (2 * 2 + (N - 1) * 2) / 2;
			}

			System.out.println("#" + testCase + " " + (oddNum - evenNum));
		}
	}
}
