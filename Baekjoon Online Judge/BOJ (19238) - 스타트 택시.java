import java.io.*;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
	private static int n, m, fuel, taxiR, taxiC;
	private static int[] dc = { 0, 0, -1, 1 };
	private static int[] dr = { -1, 1, 0, 0 };
	private static int[][] map;
	private static boolean[][] visited;
	private static PriorityQueue<int[]> pq;

	private static boolean isRange(int r, int c) {
		return r > 0 && c > 0 && r <= n && c <= n;
	}

	private static void findPassenger(int r, int c) {
		int minFuel = Integer.MAX_VALUE;
		visited = new boolean[n + 1][n + 1];
		Queue<int[]> qu = new LinkedList<int[]>();

		qu.offer(new int[] { r, c, 0 });
		visited[r][c] = true;

		while (!qu.isEmpty()) {
			int[] now = qu.poll();

			// 승객 찾음
			if (map[now[0]][now[1]] == 2) {
				minFuel = Math.min(minFuel, now[2]);
				pq.add(new int[] { now[0], now[1], now[2] });
				continue;
			}

			// 4방향 탐색
			for (int i = 0; i < 4; i++) {
				int nextR = now[0] + dr[i];
				int nextC = now[1] + dc[i];

				if (!isRange(nextR, nextC) || map[nextR][nextC] == 1)
					continue;

				if (now[2] + 1 > fuel || now[2] + 1 > minFuel)
					continue;

				if (!visited[nextR][nextC]) {
					visited[nextR][nextC] = true;
					qu.offer(new int[] { nextR, nextC, now[2] + 1 });
				}
			}
		}
	}

	private static int goToDestination(int r, int c, int destR, int destC) {
		visited = new boolean[n + 1][n + 1];
		Queue<int[]> qu = new LinkedList<int[]>();

		qu.offer(new int[] { r, c, 0 });
		visited[r][c] = true;

		while (!qu.isEmpty()) {
			int[] now = qu.poll();

			if (now[0] == destR && now[1] == destC) {
				return now[2];
			}

			// 4방향 탐색
			for (int i = 0; i < 4; i++) {
				int nextR = now[0] + dr[i];
				int nextC = now[1] + dc[i];

				if (!isRange(nextR, nextC) || map[nextR][nextC] == 1)
					continue;

				if (now[2] + 1 > fuel)
					continue;

				if (!visited[nextR][nextC]) {
					visited[nextR][nextC] = true;
					qu.offer(new int[] { nextR, nextC, now[2] + 1 });
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
		HashMap<String, int[]> hm = new HashMap<String, int[]>();

		n = Integer.parseInt(tokenizer.nextToken());
		m = Integer.parseInt(tokenizer.nextToken());
		fuel = Integer.parseInt(tokenizer.nextToken());
		pq = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[2] == o2[2]) {
					if (o1[0] == o2[0]) {
						return o1[1] - o2[1];
					}
					return o1[0] - o2[0];
				}
				return o1[2] - o2[2];
			}
		});

		map = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			tokenizer = new StringTokenizer(br.readLine(), " ");

			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(tokenizer.nextToken());
			}
		}

		// 택시 위치
		tokenizer = new StringTokenizer(br.readLine(), " ");
		taxiR = Integer.parseInt(tokenizer.nextToken());
		taxiC = Integer.parseInt(tokenizer.nextToken());

		for (int i = 0; i < m; i++) {
			tokenizer = new StringTokenizer(br.readLine(), " ");

			int r = Integer.parseInt(tokenizer.nextToken());
			int c = Integer.parseInt(tokenizer.nextToken());
			int destR = Integer.parseInt(tokenizer.nextToken());
			int destC = Integer.parseInt(tokenizer.nextToken());

			map[r][c] = 2;
			hm.put(r + "," + c, new int[] { destR, destC });
		}

		while (m > 0) {
			findPassenger(taxiR, taxiC);

			if (pq.isEmpty()) {
				fuel = -1;
				break;
			}

			int[] now = pq.poll();
			pq.clear();
			map[now[0]][now[1]] = 0;
			fuel -= now[2];

			// 도착정보
			int[] info = hm.get(now[0] + "," + now[1]);
			int need = goToDestination(now[0], now[1], info[0], info[1]);

			if (need == -1) {
				fuel = -1;
				break;
			}

			fuel += need;
			taxiR = info[0];
			taxiC = info[1];
			m--;
		} // end of while
		System.out.println(fuel);
	} // end of main
}