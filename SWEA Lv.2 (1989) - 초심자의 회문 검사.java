import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;

		T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			String word = sc.next();
			int len = word.length() - 1, cnt = len / 2, res = 1;

			for (int i = 0; i < cnt; i++) {
				if (word.charAt(i) != word.charAt(len - i)) {
					res = 0;
					break;
				}
			}
			System.out.println("#" + testCase + " " + res);
		}
	}
}
