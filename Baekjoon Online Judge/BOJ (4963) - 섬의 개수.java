import java.util.*;
import java.awt.Point;
import java.io.*;

public class Main {
	private static int w, h, res;
	private static int[] dx = { 0, 0, -1, 1, -1, -1, 1, 1 };
	private static int[] dy = { -1, 1, 0, 0, -1, 1, -1, 1 };
	private static int[][] map;
	private static boolean[][] visited;

	private static boolean isRange(int x, int y) {
		if (x < 0 || y < 0 || x >= w || y >= h) {
			return false;
		}
		return true;
	}

	private static void bfs(int x, int y) {
		Queue<Point> qu = new LinkedList<Point>();
		qu.add(new Point(x, y));
		visited[y][x] = true;

		while (!qu.isEmpty()) {
			Point now = qu.poll();

			for (int i = 0; i < 8; i++) {
				int nextX = now.x + dx[i];
				int nextY = now.y + dy[i];

				if (!isRange(nextX, nextY)) {
					continue;
				}

				if (map[nextY][nextX] == 1 && !visited[nextY][nextX]) {
					visited[nextY][nextX] = true;
					qu.offer(new Point(nextX, nextY));
				}
			}
		}
		res++;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(tokenizer.nextToken());
			h = Integer.parseInt(tokenizer.nextToken());
			if (w == 0 && h == 0) {
				break;
			}
			res = 0;
			map = new int[h][w];
			visited = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				tokenizer = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(tokenizer.nextToken());
				}
			}
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						bfs(j, i);
					}
				}
			}
			System.out.println(res);
		}
	} // end of main
} // end of class
