import java.util.*;
import java.io.*;

public class Main {
	private static int N, M;
	private static long[][] distances;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		distances = new long[N + 1][N + 1];
		
		// 초기화
		for (int i = 1; i < N + 1; i++) {
			for (int j = 0; j < N + 1; j++) {
				if (i == j) {
					distances[i][i] = 0;
				} else {
					distances[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		// 값 입력
		for (int i = 0; i < M; i++) {
			tokenizer = new StringTokenizer(br.readLine(), " ");

			int from = Integer.parseInt(tokenizer.nextToken());
			int to = Integer.parseInt(tokenizer.nextToken());
			int distance = Integer.parseInt(tokenizer.nextToken());

			distances[from][to] = Math.min(distances[from][to], distance);
		}
		// 플로이드 와샬
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (distances[i][j] > distances[i][k] + distances[k][j]) {
						distances[i][j] = distances[i][k] + distances[k][j];
					}
				}
			}
		}
		// 출력
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				// 갈 수 있는 길이 없는 경우
				if(distances[i][j] == Integer.MAX_VALUE) {
					distances[i][j] = 0;
				}
				sb.append(distances[i][j]).append(" ");
			}
			sb.delete(sb.length() - 1, sb.length());
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}
