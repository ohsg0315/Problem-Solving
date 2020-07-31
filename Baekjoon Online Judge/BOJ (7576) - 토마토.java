import java.util.*;
import java.awt.Point;
import java.io.*;

public class Main {
	private static int N, M;
	private static int[] dx = { 0, 0, -1, 1 };
	private static int[] dy = { -1, 1, 0, 0 };
	private static int[][] box;
	private static Queue<Point> today, tomorrow;

	private static boolean isRange(int x, int y) {
		if (x < 0 || y < 0 || x >= M || y >= N) {
			return false;
		}
		return true;
	}

	private static int tomato(int x, int y) {
		int change = 0;

		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (!isRange(nextX, nextY)) {
				continue;
			}

			if (box[nextY][nextX] == 0) {
				box[nextY][nextX] = 1;
				tomorrow.offer(new Point(nextX, nextY));
				change++;
			}
		}
		return change;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
		int tomatoNum = 0, change, res = 0, cnt = 0;
		;
		boolean flag = true;
		M = Integer.parseInt(tokenizer.nextToken());
		N = Integer.parseInt(tokenizer.nextToken());
		box = new int[N][M];
		today = new LinkedList<Point>();
		tomorrow = new LinkedList<Point>();

		for (int i = 0; i < N; i++) {
			tokenizer = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(tokenizer.nextToken());

				if (box[i][j] == 0) {
					tomatoNum++;
				}
				if (box[i][j] == 1) {
					today.offer(new Point(j, i));
				}
			}
		}

		while (tomatoNum > 0) {
			change = 0;

			while (!today.isEmpty()) {
				Point now = today.poll();
				change += tomato(now.x, now.y);
			}

			if (change == 0) {
				flag = false;
				break;
			}
			tomatoNum -= change;
			res++;

			today = tomorrow;
			tomorrow = new LinkedList<Point>();
		}

		if (flag) {
			System.out.println(res);
		} else {
			System.out.println("-1");
		}
	} // end of main
} // end of class
