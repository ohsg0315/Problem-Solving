import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		// N까지 입력
		for (int i = 1; i <= N; i++) {
			sb.append(i);
			sb.append(" ");
		}
		
		// 3, 6, 9 인경우 -로 변환
		String buf = sb.toString();
		buf = buf.replaceAll("[369]", "-");
		sb.delete(0, sb.length());

		// -가 포함된 경우 -만 카운트하여 출력 and 숫자는 그대로 출력
		String[] res = buf.split(" ");
		for (String s : res) {
			if (s.contains("-")) {
				for (int i = 0; i < s.length(); i++) {
					if (s.charAt(i) == '-')
						sb.append('-');
				}
				System.out.print(sb.toString() + " ");
				sb.delete(0, sb.length());

			} else {
				System.out.print(s + " ");
			}
		}
	}
}
