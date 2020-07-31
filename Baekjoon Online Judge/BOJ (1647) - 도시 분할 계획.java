import java.util.*;
import java.io.*;

public class Main {
	private static int[] parent;

	private static class Edge {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}

	private static int findParent(int a) {
		if (parent[a] == a) {
			return a;
		}
		return parent[a] = findParent(parent[a]);
	}

	private static void mergeParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);

		if (a < b) {
			parent[b] = a;
		} else {
			parent[a] = b;
		}
	}

	private static boolean isMerge(int a, int b) {
		a = findParent(a);
		b = findParent(b);

		if (a == b) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(tokenizer.nextToken()), M = Integer.parseInt(tokenizer.nextToken());
		parent = new int[N + 1];
		ArrayList<Edge> edge = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < M; i++) {
			tokenizer = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(tokenizer.nextToken());
			int to = Integer.parseInt(tokenizer.nextToken());
			int weight = Integer.parseInt(tokenizer.nextToken());

			edge.add(new Edge(from, to, weight));
		}

		Collections.sort(edge, new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				// TODO Auto-generated method stub
				return o1.weight - o2.weight;
			}
		});

		int sum = 0, cnt = 0;
		for (int i = 0; i < N - 2; cnt++) {
			Edge now = edge.get(cnt);

			if (!isMerge(now.from, now.to)) {
				sum += now.weight;
				mergeParent(now.from, now.to);
				i++;
			}
		}
		System.out.println(sum);
	} // end of main
} // end of class
