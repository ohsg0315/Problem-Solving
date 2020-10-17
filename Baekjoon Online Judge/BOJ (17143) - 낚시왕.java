import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int r, c, m, pos, res;
	private static int[] dx = { 0, 0, 0, 1, -1 };
	private static int[] dy = { 0, -1, 1, 0, 0 };
	private static Shark[][] map;
	private static PriorityQueue<Shark> pq;

	private static class Shark {
		int r, c, s, d, z;

		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public String toString() {
			return "[" + z + "]";
		}
	}

	private static void catchShark() {
		int row = 0;
		while (row < r) {
			if (map[row][pos] != null) {
				res += map[row][pos].z;
				pq.remove(map[row][pos]);
				map[row][pos] = null;
				return;
			}
			row++;
		}
	}

	private static void moveShark() {
		Queue<Shark> qu = new LinkedList<Shark>();
		while (!pq.isEmpty()) {
			Shark sh = pq.poll();
			int cnt = sh.s;
			int nextX = sh.c, nextY = sh.r;

			// 상하 방향
			if (sh.d == 1 || sh.d == 2) {
				while (cnt-- > 0) {
					nextY += dy[sh.d];

					// 상
					if (nextY == 0) {
						sh.d = 2;
						nextY = 1 + dy[sh.d];
					}
					// 하
					else if (nextY == r) {
						sh.d = 1;
						nextY = r - 1 + dy[sh.d];
					}
				}
			}
			// 좌우 방향
			else if (sh.d == 3 || sh.d == 4) {
				while (cnt-- > 0) {
					nextX += dx[sh.d];

					// 좌
					if (nextX == 0) {
						sh.d = 3;
						nextX = 1 + dx[sh.d];
					}
					// 우
					if (nextX == c) {
						sh.d = 4;
						nextX = c - 1 + dx[sh.d];
					}
				}
			} // end of if
			if (sh.z == map[sh.r][sh.c].z)
				map[sh.r][sh.c] = null;

			sh.c = nextX;
			sh.r = nextY;
			if (map[sh.r][sh.c] != null && map[sh.r][sh.c].z < sh.z) {
				qu.remove(map[sh.r][sh.c]);
			}
			map[nextY][nextX] = sh;
			qu.offer(sh);
		}
		while (!qu.isEmpty())
			pq.add(qu.poll());
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

		r = Integer.parseInt(tokenizer.nextToken()) + 1;
		c = Integer.parseInt(tokenizer.nextToken()) + 1;
		m = Integer.parseInt(tokenizer.nextToken());
		map = new Shark[r][c];
		pq = new PriorityQueue<Shark>(new Comparator<Shark>() {

			@Override
			public int compare(Shark o1, Shark o2) {
				return o1.z - o2.z;
			}
		});

		for (int i = 0; i < m; i++) {
			tokenizer = new StringTokenizer(br.readLine(), " ");

			int r = Integer.parseInt(tokenizer.nextToken());
			int c = Integer.parseInt(tokenizer.nextToken());
			int s = Integer.parseInt(tokenizer.nextToken());
			int d = Integer.parseInt(tokenizer.nextToken());
			int z = Integer.parseInt(tokenizer.nextToken());

			Shark shark = new Shark(r, c, s, d, z);
			map[r][c] = shark;
			pq.offer(shark);
		}

		while (++pos < c) {
			catchShark();
			moveShark();
		}
		System.out.println(res);
	}
}
