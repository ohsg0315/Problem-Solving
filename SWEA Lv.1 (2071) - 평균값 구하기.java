import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		int T;
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int testCase = 1; testCase <= T; testCase++) {
			int sum = 0;

			for (int i = 0; i < 10; i++) {
				sum += sc.nextInt();
			}
			sum = (int) Math.round((double) sum / 10);
			System.out.println("#" + testCase + " " + sum);
		}
	}
}
