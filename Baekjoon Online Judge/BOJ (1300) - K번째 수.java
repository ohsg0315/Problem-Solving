import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int result = -1;
        int low = 1, high = k, mid;
        while (low <= high) {
            long cnt = 0;
            mid = low + (high - low) / 2;

            for (int row = 1; row <= N; row++) {
                cnt += Math.min(mid / row, N);
            }

            if (cnt < k) {
                low = mid + 1;
            } else {
                result = mid;
                high = mid - 1;
            }
        }

        System.out.println(result);
    }
}