import java.util.*;
import java.io.*;

public class Main {
	private static int N, res = Integer.MIN_VALUE;
	private static ArrayList<String> original;

	private static int cal(int a, int b, char c) {
		switch (c) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		}
		return -1;
	}

	private static void dfs(int total, int idx) {
		if (idx == N) {
			if (total > res) {
				res = total;
			}
			return;
		}

		// 괄호 사용
		if (idx + 3 < N) {
			int a = Integer.parseInt(original.get(idx + 1));
			int b = Integer.parseInt(original.get(idx + 3));
			char operator = original.get(idx + 2).charAt(0);

			int buf = cal(a, b, operator);
			dfs(cal(total, buf, original.get(idx).charAt(0)), idx + 4);
		}

		// 괄호 사용 X
		char operator = original.get(idx).charAt(0);
		int a = Integer.parseInt(original.get(idx + 1));

		dfs(cal(total, a, operator), idx + 2);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		original = new ArrayList<String>();
		for (int i = 0; i < s.length(); i++) {
			original.add(s.charAt(i) + "");
		}
		dfs(Integer.parseInt(original.get(0)), 1);
		System.out.println(res);
	}
}
