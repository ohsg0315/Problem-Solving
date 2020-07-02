import java.util.*;

public class Test {
	public class Target {
		int cur = 0, cnt = 0;
		int[] op = { 1, -1 };

		public Target(int cur, int cnt) {
			this.cur = cur;
			this.cnt = cnt;
		}
	}

	// BFS
	private int bfs(int[] numbers, int target) {
		int res = 0, len = numbers.length;
		Queue<Target> qu = new LinkedList<>();

		qu.offer(new Target(0, 0));

		while (!qu.isEmpty()) {
			Target now = qu.poll();
			int cur = now.cur;
			int cnt = now.cnt;

			if (cnt == len && cur == target) {
				res++;
			}
			if (cnt >= len) {
				continue;
			}
			for (int op : now.op) {
				qu.offer(new Target(cur + op * numbers[cnt], cnt + 1));
			}
		}
		return res;
	}

	// DFS
	private int dfs(int[] numbers, int target, int cur, int cnt) {
		if (cnt == numbers.length) {
			if (cur == target) {
				return 1;
			}
			return 0;
		}

		return dfs(numbers, target, cur + numbers[cnt], cnt + 1) + dfs(numbers, target, cur - numbers[cnt], cnt + 1);
	}

	public int solution(int[] numbers, int target) {
		int answer = 0;

		// answer = bfs(numbers, target);
		answer = dfs(numbers, target, 0, 0);

		return answer;
	}

	public static void main(String[] args) {
		Test test = new Test();
		System.out.println(test.solution(new int[] { 1, 1, 1, 1, 1 }, 3));
	}
}
