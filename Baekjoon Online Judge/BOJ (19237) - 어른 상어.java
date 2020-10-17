import java.io.*;
import java.util.*;

public class Main {
	private static int n, m, k;
	private static int[] dx = { 0, 0, 0, -1, 1 };
	private static int[] dy = { 0, -1, 1, 0, 0 };
	private static int[][] map;
	private static Smell[][] smell;
	private static PriorityQueue<Integer> pq;
	private static Shark[] shark;

	private static class Smell {
		int cnt, shark;

		public Smell(int cnt, int shark) {
			this.cnt = cnt;
			this.shark = shark;
		}

		@Override
		public String toString() {
			return "[" + shark + ", " + cnt + "]";
		}

	}

	private static class Shark {
		int r, c, num, dir;
		int[][] priDir = new int[5][4];

		public Shark(int r, int c, int num) {
			super();
			this.r = r;
			this.c = c;
			this.num = num;
		}
	}

	private static boolean isRange(int x, int y) {
		return x > 0 && y > 0 && x <= n && y <= n;
	}

	private static void spreadSmell() {
		Queue<Integer> qu = new LinkedList<Integer>();

		while (!pq.isEmpty()) {
			int num = pq.poll();

			Shark sh = shark[num];
			smell[sh.r][sh.c] = new Smell(k, num);
			qu.offer(num);
		}
		while (!qu.isEmpty())
			pq.offer(qu.poll());
	}

	private static void moveShark(int num) {
		Shark sh = shark[num];

		int x = sh.c, y = sh.r;
		int nextX, nextY;
		int dir = sh.dir;
		boolean flag = false;

		// 냄새가 없는 칸
		for (int i = 0; i < 4; i++) {
			nextX = x + dx[sh.priDir[dir][i]];
			nextY = y + dy[sh.priDir[dir][i]];

			if (!isRange(nextX, nextY))
				continue;

			if (smell[nextY][nextX] == null) {
				flag = true;

				sh.r = nextY;
				sh.c = nextX;
				sh.dir = sh.priDir[dir][i];
				map[y][x] = 0;
				map[nextY][nextX] = num;
				break;
			}
		}

		if (flag)
			return;

		// 냄새가 있는 칸
		for (int i = 0; i < 4; i++) {
			nextX = x + dx[sh.priDir[dir][i]];
			nextY = y + dy[sh.priDir[dir][i]];

			if (!isRange(nextX, nextY))
				continue;

			Smell sm = smell[nextY][nextX];
			if (sm != null && sm.shark == num) {
				flag = true;

				sh.r = nextY;
				sh.c = nextX;
				sh.dir = sh.priDir[dir][i];
				map[y][x] = 0;
				map[nextY][nextX] = num;
				break;
			}
		}
	}

	private static void refreshShark() {
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (map[i][j] != 0)
					pq.offer(map[i][j]);

				if (smell[i][j] != null) {
					smell[i][j].cnt--;
					
					if(smell[i][j].cnt == 0)
						smell[i][j] = null;
				}
			}
		}
	}
	
	private static void move() {
		while (!pq.isEmpty()) {
			int num = pq.poll();
			moveShark(num);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(tokenizer.nextToken());
		m = Integer.parseInt(tokenizer.nextToken());
		k = Integer.parseInt(tokenizer.nextToken());
		map = new int[n + 1][n + 1];
		smell = new Smell[n + 1][n + 1];
		shark = new Shark[m + 1];
		pq = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
		});

		for (int i = 1; i < n + 1; i++) {
			tokenizer = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < n + 1; j++) {
				map[i][j] = Integer.parseInt(tokenizer.nextToken());

				if (map[i][j] != 0) {
					shark[map[i][j]] = new Shark(i, j, map[i][j]);
					pq.offer(map[i][j]);
				}
			}
		}

		// 상어 방향
		tokenizer = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i < m + 1; i++) {
			int dir = Integer.parseInt(tokenizer.nextToken());
			shark[i].dir = dir;
		}

		// 상어 방향 우선순위
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j <= 4; j++) {
				tokenizer = new StringTokenizer(br.readLine(), " ");

				for (int k = 0; k < 4; k++) {
					int dir = Integer.parseInt(tokenizer.nextToken());
					shark[i].priDir[j][k] = dir;
				}
			}
		}
		int time = 0;
		spreadSmell();
		while (time <= 1000) {

			// 상어 이동
			move();
			
			refreshShark();

			// 냄새 뿌리기
			spreadSmell();

			time++;

			if (pq.size() == 1)
				break;
		} // end of while
		if(time > 1000) time = -1;
		System.out.println(time);
	} // end of main
}
