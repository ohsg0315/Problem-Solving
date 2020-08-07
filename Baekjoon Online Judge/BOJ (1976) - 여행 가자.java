import java.util.*;
import java.io.*;

public class Main {
	private static int n, m;
	private static int[] cities;

	private static int find(int a) {
		if (cities[a] == a) {
			return a;
		}
		return cities[a] = find(cities[a]);
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a < b) {
			cities[b] = a;
		} else {
			cities[a] = b;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		cities = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			cities[i] = i;
		}

		for (int i = 0; i < n; i++) {
			tokenizer = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				int cur = Integer.parseInt(tokenizer.nextToken());

				if (cur == 1) {
					union(i + 1, j + 1);
				}
			}
		}
		tokenizer = new StringTokenizer(br.readLine(), " ");
		int res = cities[Integer.parseInt(tokenizer.nextToken())];

		for (int i = 1; i < m; i++) {
			int cur = cities[Integer.parseInt(tokenizer.nextToken())];
			
			if (res != cur) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
}
