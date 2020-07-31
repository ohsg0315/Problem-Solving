import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
		int res = 0;
		int N = Integer.parseInt(tokenizer.nextToken());
		int K = Integer.parseInt(tokenizer.nextToken());
		int[] coin = new int[N];

		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		for (int i = N - 1; i >= 0; i--) {
			res += K / coin[i];
			K %= coin[i];

			if (K == 0) {
				break;
			}
		}
		System.out.println(res);
	}
}
