import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[] applicants = new int[n + 1];

			for (int i = 0; i < n; i++) {
				tokenizer = new StringTokenizer(br.readLine(), " ");
				int documentRank = Integer.parseInt(tokenizer.nextToken());
				int interviewRank = Integer.parseInt(tokenizer.nextToken());

				applicants[documentRank] = interviewRank;
			}
			// 개 느린 코드 . O(n^2) 2224ms
			/*
			int res = 0;
			for (int i = 1; i <= n; i++) {
				boolean flag = true;
				for (int j = i - 1; j > 0; j--) {
					if (applicants[i] > applicants[j]) {
						flag = false;
						break;
					}
				}
				if (flag) {
					res++;
				}
			}
			*/
			
			// O(n)이라 빠르다. 452ms
			int minRank = applicants[1], res = 1;
			for (int i = 2; i < n + 1; i++) {
				if (applicants[i] < minRank) {
					res++;
					minRank = applicants[i];
				}
			}
			System.out.println(res);
		}
	}

}
