import java.util.*;
import java.awt.Point;
import java.io.*;

public class Main {
	private static int n, m, year = 0;
	private static int[] dx = { 0, 0, -1, 1 };
	private static int[] dy = { -1, 1, 0, 0 };
	private static int[][][] map;
	private static boolean[][] visited;
	
	private static boolean isRange(int x, int y) {
		if (x < 0 || y < 0 || x >= m || y >= n) {
			return false;
		}
		return true;
	}
	
	// 빙산이 녹는 수치 파악 후  map[y][x][1] 에 넣음
	private static void spendTime(int x, int y) {
		int sea = 0;
		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (!isRange(nextX, nextY)) {
				continue;
			}

			if (map[nextY][nextX][0] == 0) {
				sea++;
			}
		}
		map[y][x][1] = sea;
	}
	
	// 녹을 빙산 한번에 갱신
	private static void refreshMap() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j][1] != 0) {
					map[i][j][0] -= map[i][j][1];

					map[i][j][0] = map[i][j][0] > 0 ? map[i][j][0] : 0;
					map[i][j][1] = 0;
				}
			}
		}
	}
	
	// 빙산이 하나인지 BFS를 이용해 파악. island의 값이 빙산의 갯수
	private static int isOne() {
		int island = 0;
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j][0] != 0 && !visited[i][j]) {
					bfs(j, i);
					island++;
				}
			}
		}
		return island;
	}

	private static void bfs(int x, int y) {
		Queue<Point> qu = new LinkedList<Point>();
		qu.offer(new Point(x, y));
		visited[y][x] = true;

		while (!qu.isEmpty()) {
			Point p = qu.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = p.x + dx[i];
				int nextY = p.y + dy[i];

				if (!isRange(nextX, nextY)) {
					continue;
				}

				if (map[nextY][nextX][0] != 0 && !visited[nextY][nextX]) {
					visited[nextY][nextX] = true;
					qu.offer(new Point(nextX, nextY));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(tokenizer.nextToken());
		m = Integer.parseInt(tokenizer.nextToken());
		map = new int[n][m][2];

		for (int i = 0; i < n; i++) {
			tokenizer = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j][0] = Integer.parseInt(tokenizer.nextToken());
			}
		}
		while (true) {
			year++;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j][0] != 0) {
						spendTime(j, i);
					}
				}
			}
			refreshMap();
			int flag = isOne();
			if (flag > 1) {
				System.out.println(year);
				break;
			} else if (flag == 0) {
				System.out.println(0);
				break;
			}
		}
	}

}
