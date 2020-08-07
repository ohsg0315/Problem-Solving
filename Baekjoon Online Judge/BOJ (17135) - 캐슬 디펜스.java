import java.util.*;
import java.awt.Point;
import java.io.*;

public class Main {
	private static int N, M, D, res, enemy;
	private static int[] dx = { -1, 0, 1 };
	private static int[] dy = { 0, -1, 0 };
	private static int[][] map, play;
	private static ArrayList<Integer> archer = new ArrayList<>();

	// 적 한칸 아래로 이동
	private static int[][] moveEnemy() {
		int[][] newMap = new int[N][M];

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newMap[i][j] = play[i - 1][j];
				if (newMap[i][j] == 2) {
					newMap[i][j] = 0;
				}
			}
		}
		return newMap;
	}

	// 배열 복사
	private static int[][] deepCopy() {
		int[][] newMap = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newMap[i][j] = map[i][j];
			}
		}
		return newMap;
	}

	// 거리 계산
	private static int calDist(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

	private static boolean isRange(int x, int y) {
		if (x < 0 || y < 0 || x >= M || y >= N) {
			return false;
		}
		return true;
	}

	private static void combination(int idx, int cnt) {
		if (cnt == 3) {
			int t = enemy, total = 0;
			play = deepCopy();

			while (t > 0) {
				int fire = 0;

				for (int i = 0; i < 3; i++) {
					if (play[N - 1][archer.get(i)] != 0) {
						if (play[N - 1][archer.get(i)] != 2) {
							fire++;
							total++;
						}
						play[N - 1][archer.get(i)] = 2;
						continue;
					}

					boolean[][] visited = new boolean[N][M];
					Queue<Point> qu = new LinkedList<Point>();
					qu.offer(new Point(archer.get(i), N - 1));

					ex: while (!qu.isEmpty()) {
						Point p = qu.poll();

						for (int j = 0; j < 3; j++) {
							int nextX = p.x + dx[j];
							int nextY = p.y + dy[j];

							if (!isRange(nextX, nextY)) {
								continue;
							}

							if (!visited[nextY][nextX] && calDist(archer.get(i), N, nextX, nextY) <= D) {
								visited[nextY][nextX] = true;

								if (play[nextY][nextX] != 0) {
									if (play[nextY][nextX] != 2) {
										fire++;
										total++;
									}
									play[nextY][nextX] = 2;
									break ex;
								}

								qu.offer(new Point(nextX, nextY));
							}
						}

					}
				} // end of fire

				for (int i = 0; i < M; i++) {
					if (play[N - 1][i] == 1) {
						t--;
					}
				}
				t -= fire;
				play = moveEnemy();
			} // end of while
			res = Math.max(res, total);
			return;
		}

		// 조합
		for (int i = idx; i < M; i++) {
			archer.add(i);
			combination(i + 1, cnt + 1);

			archer.remove(cnt);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(tokenizer.nextToken());
		M = Integer.parseInt(tokenizer.nextToken());
		D = Integer.parseInt(tokenizer.nextToken());

		map = new int[N][M];
		play = new int[N][M];

		for (int i = 0; i < N; i++) {
			tokenizer = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(tokenizer.nextToken());

				if (map[i][j] == 1) {
					enemy++;
				}
			}
		}

		combination(0, 0);
		System.out.println(res);
	}
}
