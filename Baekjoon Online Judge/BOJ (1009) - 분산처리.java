import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer tokenizer;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int res = 1;

            while (b-- > 0) {
                res = (res * a) % 10;
            }
            if (res == 0) res = 10;
            sb.append(res).append('\n');
        }
        System.out.print(sb.toString());
    }
}