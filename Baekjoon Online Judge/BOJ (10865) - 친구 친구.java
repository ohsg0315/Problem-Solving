import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int[] list = new int[N + 1];
        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");

            list[Integer.parseInt(tokenizer.nextToken())]++;
            list[Integer.parseInt(tokenizer.nextToken())]++;
        }
        for (int i = 1; i <= N; i++) {
            sb.append(list[i]).append('\n');
        }
        System.out.print(sb.toString());
    } // end of main
}