import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		int T;
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int[] buf = new int[2];

			for (int i = 0; i < 2; i++) {
				buf[i] = sc.nextInt();
			}

			String res = buf[0] > buf[1] ? ">" : (buf[0] < buf[1] ? "<" : "=");
			System.out.println("#" + testCase + " " + res);
		}
	}
}
