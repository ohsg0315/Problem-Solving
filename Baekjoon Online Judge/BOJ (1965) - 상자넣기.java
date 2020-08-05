import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		TreeSet<Integer> ts = new TreeSet<>();
		StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

		ts.add(0);
		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(tokenizer.nextToken());

			if (ts.last() > cur) {
				ts.remove(ts.ceiling(cur));
			}
			ts.add(cur);
		}
		System.out.println(ts.size() - 1);
	}
}
