import java.util.*;

public class Test {
	// 순열
	public class Permutation {
		private int n, r;
		private ArrayList<Integer> itemList;
		private HashSet<Integer> hs;
		private StringBuilder sb;

		public Permutation(int[] intArr, int r, HashSet<Integer> hs) {
			this.r = r;
			this.n = intArr.length;
			this.sb = new StringBuilder();
			this.hs = hs;

			itemList = new ArrayList<>();
			for (int item : intArr)
				itemList.add(item);
		}

		public void perm() {
			perm(itemList, 0);
		}

		public void perm(ArrayList<Integer> itemList, int depth) {
			if (depth == this.r) {
				int buf = Integer.parseInt(sb.toString());

				if (isPrimary(buf)) {
					hs.add(buf);
				}
				return;
			}
			for (int i = 0; i < n - depth; i++) {
				sb.append(itemList.remove(i));

				if (sb.charAt(0) != '0') {
					perm(itemList, depth + 1);
				}
				itemList.add(i, sb.charAt(depth) - '0');
				sb.deleteCharAt(depth);
			}
		}
	}

	// 소수 판별
	private boolean isPrimary(int number) {
		if (number < 2)
			return false;

		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0)
				return false;
		}
		return true;
	}

	public int solution(String numbers) {
		int len = numbers.length();
		int[] intArr = Arrays.stream(numbers.split("")).mapToInt(Integer::parseInt).toArray();
		HashSet<Integer> hs = new HashSet<>();

		for (int i = 1; i <= len; i++) {
			Permutation permutation = new Permutation(intArr, i, hs);
			permutation.perm();
		}
		return hs.size();
	}

	public static void main(String[] args) {
		Test test = new Test();
		System.out.println(test.solution("011"));
	}
}
