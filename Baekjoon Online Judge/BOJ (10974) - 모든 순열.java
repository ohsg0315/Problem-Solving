import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    private static int N;
    private static int[] arr, result;
    private static boolean[] pick;
    private static StringBuilder stringBuilder;

    private static void permutation(int cnt) {
        if (cnt == N) {
            for (int i = 0; i < N; i++) {
                stringBuilder.append(result[i]).append(' ');
            }
            stringBuilder.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!pick[i]) {
                pick[i] = true;
                result[cnt] = arr[i];

                permutation(cnt + 1);

                pick[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        result = new int[N];
        pick = new boolean[N];
        stringBuilder = new StringBuilder();

        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        permutation(0);
        System.out.println(stringBuilder.toString());
    }
}