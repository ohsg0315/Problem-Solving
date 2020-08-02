import java.util.*;
import java.io.*;

public class Solution {
	private static int N;
	private static int[] dx = { 0, 0, -1, 1 };
	private static int[] dy = { -1, 1, 0, 0 };
	private static int[][] room, cache;

	private static boolean isRange(int x, int y) {
		if (x < 0 || y < 0 || x >= N || y >= N) {
			return false;
		}
		return true;
	}

	private static int dfs(int x, int y) {
		cache[y][x] = 1;

		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (!isRange(nextX, nextY)) {
				continue;
			}

			if (room[nextY][nextX] - room[y][x] == 1) {
				if (cache[nextY][nextX] != 0) {
					return cache[y][x] += cache[nextY][nextX];
				}
				return cache[y][x] += dfs(nextX, nextY);
			}
		}
		return cache[y][x];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer tokenizer;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			int res = 0, x = -1, y = -1;
			N = Integer.parseInt(br.readLine());
			room = new int[N][N];
			cache = new int[N][N];

			for (int i = 0; i < N; i++) {
				tokenizer = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					room[i][j] = Integer.parseInt(tokenizer.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (cache[i][j] == 0) {
						dfs(j, i);
					}
					if (cache[i][j] == res) {
						if (room[i][j] < room[y][x]) {
							x = j;
							y = i;
						}
					} else if (cache[i][j] > res) {
						x = j;
						y = i;
						res = cache[i][j];
					}
				}
			}
			System.out.println("#" + testCase + " " + room[y][x] + " " + res);
		} // end of testCase
	} // end of main
} // end of class
