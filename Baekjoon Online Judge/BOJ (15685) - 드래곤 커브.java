import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	private static int[] dr = { 0, -1, 0, 1 };
	private static int[] dc = { 1, 0, -1, 0 };
	private static boolean[][] map;
	private static ArrayList<Integer> list;

	private static boolean isRange(int r, int c) {
		return r >= 0 && c >= 0 && r <= 100 && c <= 100;
	}

	private static ArrayList<Integer> findGeneration(int d, int g) {
		int cnt = 0;
		Stack<Integer> st = new Stack<Integer>();

		list.add(d);
		if (g == 0)
			return list;
		// 1 세대
		cnt++;
		list.add((d + 1) % 4);

		// 2 세대 이상
		while (cnt++ < g) {
			// 4
			int size = list.size();
			int len = size / 2;

			// 3 ~ 2
			for (int i = len; i < size; i++) {
				st.push(list.get(i));
			}
			while (!st.isEmpty()) {
				list.add((st.pop() + 1) % 4);
			}

			// 1 ~ 0
			for (int i = 0; i < len; i++) {
				st.push(list.get(i));
			}
			while (!st.isEmpty()) {
				list.add((st.pop() + 1) % 4);
			}
		}
		return list;
	}

	private static void markMap(int r, int c) {
		map[r][c] = true;

		int nextR = r;
		int nextC = c;

		for (int dir : list) {
			nextR += dr[dir];
			nextC += dc[dir];

			if (isRange(nextR, nextC))
				map[nextR][nextC] = true;
		}
	}

	private static int findSquare() {
		int res = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) {
					res++;
//					System.out.println(j + ", " + i);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;

		int n = Integer.parseInt(br.readLine());
		map = new boolean[101][101];
		list = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			tokenizer = new StringTokenizer(br.readLine(), " ");

			int c = Integer.parseInt(tokenizer.nextToken());
			int r = Integer.parseInt(tokenizer.nextToken());
			int d = Integer.parseInt(tokenizer.nextToken());
			int g = Integer.parseInt(tokenizer.nextToken());

			map[r][c] = true;
			list.clear();
			findGeneration(d, g);
			markMap(r, c);
		}
		System.out.println(findSquare());
	}
}
