import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.NClob;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Solution {
	private static int n, res, oriR, oriC;
	private static int[] dr = { 1, 1, -1, -1 };
	private static int[] dc = { 1, -1, -1, 1 };
	private static int[][] map;
	private static HashSet<Integer> hs;

	private static boolean isRange(int r, int c) {
		return r >= 0 && c >= 0 && r < n && c < n;
	}

	private static void dfs(int r, int c, int dir) {

		int nextR = r + dr[dir];
		int nextC = c + dc[dir];

		if (nextR == oriR && nextC == oriC) {
			res = Math.max(res, hs.size());
			return;
		}

		else if (isRange(nextR, nextC) && !hs.contains(map[nextR][nextC])) {
			hs.add(map[nextR][nextC]);
			dfs(nextR, nextC, dir);

			hs.remove(map[nextR][nextC]);
		}

		if (dir + 1 < 4) {
			nextR = r + dr[dir + 1];
			nextC = c + dc[dir + 1];

			if (nextR == oriR && nextC == oriC) {
				res = Math.max(res, hs.size());
				return;
			}

			else if (isRange(nextR, nextC) && !hs.contains(map[nextR][nextC])) {
				hs.add(map[nextR][nextC]);

				dfs(nextR, nextC, dir + 1);

				hs.remove(map[nextR][nextC]);
			}
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			res = -1;
			n = Integer.parseInt(br.readLine());
			hs = new HashSet<Integer>();
			map = new int[n][n];

			for (int i = 0; i < n; i++) {
				tokenizer = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(tokenizer.nextToken());
				}
			}

			for (int i = 0; i < n - 2; i++) {
				for (int j = 1; j < n - 1; j++) {
					hs.clear();
					hs.add(map[i][j]);

					oriR = i;
					oriC = j;
					dfs(i, j, 0);
				}
			}
			System.out.println("#" + testCase + " " + res);
		} // end of testCase
	}
}