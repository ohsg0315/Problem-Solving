import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(), b = sc.nextInt();

		if (a - b == 1 || a - b == 2) {
			System.out.println("A");
		} else if (a - b == -1 || a - b == -2) {
			System.out.println("B");
		}
	}
}
