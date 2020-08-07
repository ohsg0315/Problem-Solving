import java.util.*;
import java.io.*;

public class Solution {
	private static int[] dx = { 0, 0, -1, 1 };
	private static int[] dy = { -1, 1, 0, 0 };
	private static int[][] map;
	private static HashSet<Integer> set;

	private static boolean isRange(int x, int y) {
		if (x < 0 || y < 0 || x >= 4 || y >= 4) {
			return false;
		}
		return true;
	}

	private static void dfs(String s, int x, int y, int cnt) {
		if (cnt == 7) {
			set.add(Integer.parseInt(s));
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (!isRange(nextX, nextY)) {
				continue;
			}

			dfs(s + map[nextY][nextX], nextX, nextY, cnt + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			map = new int[4][4];
			set = new HashSet<Integer>();

			for (int i = 0; i < 4; i++) {
				tokenizer = new StringTokenizer(br.readLine(), " ");

				for (int j = 0; j < 4; j++) {
					map[i][j] = Integer.parseInt(tokenizer.nextToken());
				}
			}

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					dfs("", j, i, 0);
				}
			}
			System.out.println("#" + testCase + " " + set.size());
		} // end of testCase
	} // end of main
} // end of class
