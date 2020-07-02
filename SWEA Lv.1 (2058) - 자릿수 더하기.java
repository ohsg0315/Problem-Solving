import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		String buf = sc.next();

		for (int i = 0; i < buf.length(); i++) {
			sum += Integer.parseInt(buf.charAt(i) + "");
		}

		System.out.println(sum);
	}
}
