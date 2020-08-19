import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(tokenizer.nextToken());
        int c = Integer.parseInt(tokenizer.nextToken());

        int[] home = new int[n];
        for (int i = 0; i < n; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(home);
        int res = 0, low = 1, high = home[n - 1] - home[0];

        while (low <= high) {
            int mid = (low + high) / 2;
            int cnt = 1; // home[0]
            int cur = home[0];

            for (int i = 1; i < n; i++) {
                if (home[i] - cur >= mid) {
                    cnt++;
                    cur = home[i];
                }
            }
            if (cnt < c) {
                high = mid - 1;
            } else {
                low = mid + 1;
                if (mid > res) {
                    res = mid;
                }
            }
        }
        System.out.println(res);
    } // end of main
} // end of class