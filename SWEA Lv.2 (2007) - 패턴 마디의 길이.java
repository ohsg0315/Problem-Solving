import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;

		T = sc.nextInt();
		
		/*
		 * 1부터 10까지 마디를 늘려가며, 첫 마디와 2, 3번째 마디가 같은 경우 답으로 처리
		 * 답은 맞았지만 로직에 문제가 있다.
		 */
		for (int testCase = 1; testCase <= T; testCase++) {
			String pattern = sc.next();

			for (int i = 1; i <= 10; i++) {
				String part = pattern.substring(0, i);

				if (part.equals(pattern.substring(i, i * 2)) && part.equals(pattern.substring(i * 2, i * 3))) {
					System.out.println("#" + testCase + " " + i);
					break;
				}
			}
		}
	}
}
