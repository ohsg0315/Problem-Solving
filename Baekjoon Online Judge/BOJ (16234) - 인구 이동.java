import java.util.*;
import java.awt.Point;
import java.io.*;

public class Main {
	private static int N, L, R, res = -1;
	private static boolean flag;
	private static int[] dx = { 0, 0, -1, 1 };
	private static int[] dy = { -1, 1, 0, 0 };
	private static int[][] nation;
	private static boolean[][] visited;

	private static boolean isRange(int x, int y) {
		if (x < 0 || y < 0 || x >= N || y >= N) {
			return false;
		}
		return true;
	}

	private static void reset() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visited[i][j] = false;
			}
		}
	}

	private static void bfs(int x, int y) {
		int total = 0, cnt = 0;
		Queue<Point> qu = new LinkedList<>();
		ArrayList<Point> arr = new ArrayList<Point>();

		qu.offer(new Point(x, y));
		visited[y][x] = true;

		while (!qu.isEmpty()) {
			Point now = qu.poll();
			cnt++;
			total += nation[now.y][now.x];
			arr.add(new Point(now.x, now.y));

			for (int i = 0; i < 4; i++) {
				int nextX = now.x + dx[i];
				int nextY = now.y + dy[i];

				if (!isRange(nextX, nextY) || visited[nextY][nextX]) {
					continue;
				}

				int diff = Math.abs(nation[now.y][now.x] - nation[nextY][nextX]);
				if (L <= diff && diff <= R) {
					visited[nextY][nextX] = true;
					flag = true;
					qu.offer(new Point(nextX, nextY));
				}
			}
		}
		int div = total / cnt;
		for (int i = 0; i < cnt; i++) {
			nation[arr.get(i).y][arr.get(i).x] = div;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(tokenizer.nextToken());
		L = Integer.parseInt(tokenizer.nextToken());
		R = Integer.parseInt(tokenizer.nextToken());
		nation = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			tokenizer = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				nation[i][j] = Integer.parseInt(tokenizer.nextToken());
			}
		}

		do {
			flag = false;
			reset();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						bfs(j, i);
					}
				}
			}
			res++;

		} while (flag);
		System.out.println(res);
	}
}
