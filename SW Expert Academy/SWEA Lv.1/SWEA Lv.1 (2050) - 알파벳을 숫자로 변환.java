import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		String buf = sc.next();

		for (int i = 0; i < buf.length(); i++) {
			int res = buf.charAt(i) - 'A' + 1;
			System.out.print(res + " ");
		}
	}
}
