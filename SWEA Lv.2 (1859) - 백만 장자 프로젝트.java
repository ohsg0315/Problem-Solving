import java.util.*;

public class Solution {
	private static long getProfit(int[] arr) {
		long sum = 0;
		int maxNum = -1, maxNumIdx = -1, len = arr.length;

		// 최대값과 위치 idx 찾기.
		for (int i = 0; i < len; i++) {
			if (maxNum <= arr[i]) {
				maxNum = arr[i];
				maxNumIdx = i;
			}
		}

		// 최고가가 idx 0에 있으면 안 산다. 아닌 경우 이득 취함.
		if (maxNumIdx != 0) {
			for (int i = 0; i < maxNumIdx; i++) {
				sum -= arr[i];
			}
			sum = sum + arr[maxNumIdx] * (long) maxNumIdx;
		}

		// 최고가 뒤에 물건이 남은 경우 재귀 반복.
		if (maxNumIdx != arr.length - 1) {
			return sum + getProfit(Arrays.copyOfRange(arr, maxNumIdx + 1, arr.length));
		}

		// 안 남은 경우.값 리턴
		else {
			return sum;
		}
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;

		T = sc.nextInt();

		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt(), maxNum = -1, idx = -1;
			int[] arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
				if (maxNum <= arr[i]) {
					maxNum = arr[i];
					idx = i;
				}
			}
			long res = getProfit(arr);
			System.out.println("#" + testCase + " " + res);
		}
	}
}
