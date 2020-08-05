import java.util.*;
import java.io.*;

public class Main {
	private static int[] box;

	private static int lowerBound(int num, int high) {
		int low = 0;

		while (low < high) {
			int mid = (low + high) / 2;

			if (box[mid] >= num) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return high;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
		box = new int[N + 1];

		// 배열 사용
		int cnt = 0;
		box[0] = Integer.parseInt(tokenizer.nextToken());
		for (int i = 1; i < N; i++) {
			int cur = Integer.parseInt(tokenizer.nextToken());

			if (box[cnt] >= cur) {
				int idx = lowerBound(cur, cnt);
				box[idx] = cur;
			} else {
				box[++cnt] = cur;
			}
		}
		System.out.println(cnt + 1);

		// TreeSet 사용
		/*
		TreeSet<Integer> ts = new TreeSet<>();
		ts.add(0);
		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(tokenizer.nextToken());

			if (ts.last() > cur) {
				ts.remove(ts.ceiling(cur));
			}
			ts.add(cur);
		}
		System.out.println(ts.size() - 1);
		*/
	}
}
