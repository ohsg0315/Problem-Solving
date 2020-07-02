import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		int T;
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int testCase = 1; testCase <= T; testCase++) {
			int sum = 0;
			int[] numbers = new int[10];

			for (int i = 0; i < 10; i++) {
				numbers[i] = sc.nextInt();

				if (numbers[i] % 2 == 1)
					sum += numbers[i];
			}
			System.out.println("#" + testCase + " " + sum);
		}
	}
}
