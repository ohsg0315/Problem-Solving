import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), length = 0;
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        int[] lis = new int[N + 1], list = new int[N];

        for (int i = N - 1; i >= 0; i--) {
            list[i] = Integer.parseInt(tokenizer.nextToken());
        }

        lis[0] = -1;
        for (int i = 0; i < N; i++) {
            if (lis[length] >= list[i]) {
                int idx = Arrays.binarySearch(lis, 0, length, list[i]);
                idx = idx > 0 ? idx : -(idx + 1);
                lis[idx] = list[i];
            } else {
                lis[++length] = list[i];
            }
        }
        System.out.println(N - length);
    } // end of main
}