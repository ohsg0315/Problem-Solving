import java.util.*;
import java.awt.Point;
import java.io.*;

public class Main {
	private static int N, cnt;
	private static int[] res;
	private static int[] dx = { 0, 0, -1, 1 };
	private static int[] dy = { -1, 1, 0, 0 };
	private static int[][] village;
	private static boolean[][] visited;

	private static boolean isRange(int x, int y) {
		if (x < 0 || y < 0 || x >= N || y >= N) {
			return false;
		}
		return true;
	}

	private static int bfs(int x, int y) {
		int res = 0;
		Queue<Point> qu = new LinkedList<>();

		visited[y][x] = true;
		qu.offer(new Point(x, y));

		while (!qu.isEmpty()) {
			res++;
			Point now = qu.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = now.x + dx[i];
				int nextY = now.y + dy[i];

				if (!isRange(nextX, nextY)) {
					continue;
				}

				if (village[nextY][nextX] == 1 && !visited[nextY][nextX]) {
					visited[nextY][nextX] = true;
					qu.offer(new Point(nextX, nextY));
				}
			}
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		village = new int[N][N];
		visited = new boolean[N][N];
		res = new int[N * N];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				village[i][j] = Integer.parseInt(s.charAt(j) + "");
			}
		}
		// 탐색
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (village[i][j] == 1 && !visited[i][j]) {
					res[cnt++] = bfs(j, i);
				}
			}
		}
		// 배열 크기 초기화 && 정렬 && 답 출력
		res = Arrays.copyOf(res, cnt);
		Arrays.sort(res);
		StringBuilder sb = new StringBuilder();
		sb.append(cnt).append("\n");
		for (int i = 0; i < cnt; i++) {
			sb.append(res[i]).append("\n");
		}
		System.out.print(sb);
	}
}
