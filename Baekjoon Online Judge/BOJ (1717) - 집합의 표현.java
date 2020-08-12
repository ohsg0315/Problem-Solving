import java.util.*;
import java.io.*;

public class Main {
	private static int n, m;
	private static int[] parent;

	private static int find(int a) {
		if (parent[a] == a) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}

	private static void union(int a, int b) {
		a = find(parent[a]);
		b = find(parent[b]);

		parent[a] = b;
	}

	private static boolean isUnion(int a, int b) {
		a = find(parent[a]);
		b = find(parent[b]);

		if (a == b) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(tokenizer.nextToken());
		m = Integer.parseInt(tokenizer.nextToken());
		parent = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < m; i++) {
			tokenizer = new StringTokenizer(br.readLine());

			int type = Integer.parseInt(tokenizer.nextToken());
			int a = Integer.parseInt(tokenizer.nextToken());
			int b = Integer.parseInt(tokenizer.nextToken());

			if (type == 0) {
				union(a, b);
			} else if (type == 1) {
				if (isUnion(a, b)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}

		}

	}
}
