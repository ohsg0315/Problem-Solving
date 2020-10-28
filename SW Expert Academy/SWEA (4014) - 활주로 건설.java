import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	private static int N, X, res;
	private static int[][] map;
	private static boolean[] isSelected;

	private static int[][] rotate() {
		int[][] next = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				next[i][j] = map[N - 1 - j][i];
			}
		}
		return next;
	}

	private static boolean findPath(int r) {
		int before = map[r][0];
		isSelected = new boolean[N];

		for (int i = 1; i < N; i++) {
			int cur = map[r][i];

			// 높이 차이가 2 이상이라면 불가능
			int diff = Math.abs(before - cur);
			if (diff > 1)
				return false;

			// 높이가 같다면 통과
			else if (diff == 0)
				continue;

			// 높이 차이가 1이라면
			else if (diff == 1) {

				// 뒤에꺼가 더 높음
				if (before < cur) {
					// 경사로가 범위를 벗어나면 불가능
					if (i - X < 0)
						return false;

					for (int sub = 0; sub < X; sub++) {
						// 높이가 다르면 경사로를 놓을 수 없어서 불가능
						if (before != map[r][i - 1 - sub])
							return false;

						// 경사로를 겹치게 두면 불가능
						if (isSelected[i - 1 - sub])
							return false;
					}

					// 경사로 놓기
					for (int sub = 0; sub < X; sub++) {
						isSelected[i - 1 - sub] = true;
					}
				}
				// 앞에꺼가 더 높음
				else {
					// 경사로가 범위를 벗어나면 불가능
					if (i + X - 1 >= N)
						return false;

					for (int add = 0; add < X; add++) {
						// 높이가 다르면 경사로를 놓을 수 없어서 불가능
						if (cur != map[r][i + add])
							return false;

						// 경사로가 겹치면 불가능
						if (isSelected[i + add])
							return false;
					}
					for (int add = 0; add < X; add++) {
						isSelected[i + add] = true;
					}
				}
			}
			before = cur;
		} // end of for

		return true;
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			tokenizer = new StringTokenizer(br.readLine(), " ");

			res = 0;
			N = Integer.parseInt(tokenizer.nextToken());
			X = Integer.parseInt(tokenizer.nextToken());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				tokenizer = new StringTokenizer(br.readLine(), " ");

				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(tokenizer.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				if (findPath(i))
					res++;
			}

			map = rotate();
			for (int i = 0; i < N; i++) {
				if (findPath(i))
					res++;
			}
			System.out.println("#" + testCase + " " + res);
		}
	}
}