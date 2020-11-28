import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int[] bucket = new int[N + 1];

        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            int target = Integer.parseInt(tokenizer.nextToken());


            Arrays.fill(bucket, start, end + 1, target);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(bucket[i]).append(' ');
        }
        sb.replace(sb.length() - 1, sb.length(), "\n");
        System.out.println(sb.toString());
    } // end of main
}