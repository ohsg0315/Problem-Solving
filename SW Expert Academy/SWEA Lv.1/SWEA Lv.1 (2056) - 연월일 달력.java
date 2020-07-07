import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		int T;
		int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int testCase = 1; testCase <= T; testCase++) {
			String cal = sc.next();
			int month = Integer.parseInt(cal.substring(4, 6));
			int day = Integer.parseInt(cal.substring(6));

			if (month < 1 || month > 12 || day > months[month - 1]) {
				System.out.println("#" + testCase + " " + -1);
				continue;
			} else {
				String res = cal.substring(0, 4) + "/" + cal.substring(4, 6) + "/" + cal.substring(6);
				System.out.println("#" + testCase + " " + res);
			}
		}
	}
}
