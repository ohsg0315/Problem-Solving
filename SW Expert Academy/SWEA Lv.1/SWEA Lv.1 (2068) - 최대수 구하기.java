import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		int T;
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int testCase = 1; testCase <= T; testCase++) {
			int maxNum = -1, buf;

			for (int i = 0; i < 10; i++) {
				buf = sc.nextInt();
				maxNum = Math.max(maxNum, buf);
			}

			System.out.println("#" + testCase + " " + maxNum);
		}
	}
}
