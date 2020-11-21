import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int s = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                tokenizer = new StringTokenizer(br.readLine(), " ");

                s += Integer.parseInt(tokenizer.nextToken()) * Integer.parseInt(tokenizer.nextToken());
            }
            sb.append(s).append('\n');
        }
        System.out.print(sb.toString());
    } // end of main
}