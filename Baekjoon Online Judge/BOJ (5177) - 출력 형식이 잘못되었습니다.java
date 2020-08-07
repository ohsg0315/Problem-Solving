import java.util.*;
import java.io.*;

public class Main {
	private static boolean isAlphaNum(char c) {
		if ('0' <= c && c <= '9') {
			return true;
		}
		if ('A' <= c && c <= 'Z') {
			return true;
		}
		return false;
	}

	private static boolean isEqual(String large, String small) {
		int idx = 0;
		for (int i = 0, length = large.length(); i < length; i++) {
			char l = large.charAt(i);
			char s = small.charAt(idx);

			// 같으면 통과
			if (l == s) {
				idx++;
				continue;
			}

			// 하나는 공백일 때, 다른게 알파벳 or 숫자가 아니면 통과
			if (l == ' ' && !isAlphaNum(s)) {
				continue;
			} else if (s == ' ' && isAlphaNum(l)) {
				if (i - 1 >= 0 && isAlphaNum(large.charAt(i - 1))) {
					return false;
				}
				continue;
			}
			// 하나는 공백인데, 다른게 알파벳 or 숫자라면 -> 이전에도 알파벳 or 숫자 => not equal
			else if (l == ' ' && isAlphaNum(s)) {
				if (idx - 1 >= 0 && isAlphaNum(small.charAt(idx - 1))) {
					return false;
				}
				continue;
			} else if (s == ' ' && !isAlphaNum(l)) {
				idx++;
				continue;
			}

			// 위에서 안걸러졌다 => 알파벳 or 숫자가 서로 다르다.
			return false;
		}
		// for문 모두 통과했다면 equal
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(br.readLine());
		for (int t = 1; t <= K; t++) {
			String s1 = br.readLine();
			String s2 = br.readLine();

			// 알파벳 대문자와 소문자는 구별하지 않는다.
			s1 = s1.toUpperCase();
			s2 = s2.toUpperCase();

			// 여는 괄호끼리는 종류를 구별하지 않는다.
			s1 = s1.replace('{', '(');
			s1 = s1.replace('[', '(');
			s2 = s2.replace('{', '(');
			s2 = s2.replace('[', '(');

			// 닫는 괄호끼리는 종류를 구별하지 않는다.
			s1 = s1.replace('}', ')');
			s1 = s1.replace(']', ')');
			s2 = s2.replace('}', ')');
			s2 = s2.replace(']', ')');

			// 쉼표와 세미콜론은 구별하지 않는다
			s1 = s1.replace(';', ',');
			s2 = s2.replace(';', ',');

			// 문자열 맨 앞 혹은 맨 뒤에 나타나는 공백은 있으나 없으나 관계없다.
			s1 = s1.trim();
			s2 = s2.trim();

			boolean flag;
			if (s1.length() > s2.length()) {
				flag = isEqual(s1, s2);
			} else {
				flag = isEqual(s2, s1);
			}

			if (flag) {
				System.out.println("Data Set " + t + ": equal\n");
			} else {
				System.out.println("Data Set " + t + ": not equal\n");
			}
		}
	}
}
