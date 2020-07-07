import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;

		T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();

			// 배열 생성
			int[][] arr = new int[N][];
			for (int i = 0; i < N; i++) {
				arr[i] = new int[i + 1];
			}

			System.out.println("#" + testCase);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					if (j > 0 && arr[i - 1].length > j) {
						arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
					} else {
						arr[i][j] = 1;
					}
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
