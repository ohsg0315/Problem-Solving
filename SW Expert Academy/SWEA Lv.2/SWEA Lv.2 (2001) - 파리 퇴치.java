import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;

		T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int maxFly = -1, sum = 0;
			int N = sc.nextInt(), M = sc.nextInt();
			int[][] map = new int[N][N];

			// 맵 초기화
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			// 맵 순회
			for (int i = 0; i <= N - M; i++) {
				for (int j = 0; j <= N - M; j++) {

					// 파리 잡기
					for (int r = i; r < i + M; r++) {
						for (int c = j; c < j + M; c++) {
							sum += map[r][c];
						}
					}
					// 최대값 처리
					maxFly = Math.max(maxFly, sum);
					sum = 0;
				}
			}
			System.out.println("#" + testCase + " " + maxFly);
			maxFly = -1;
		}
	}
}
