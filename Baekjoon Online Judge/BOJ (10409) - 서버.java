import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(tokenizer.nextToken());
        int t = Integer.parseInt(tokenizer.nextToken());
        int res = 0;

        tokenizer = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int buf = Integer.parseInt(tokenizer.nextToken());

            if (t < buf) break;

            t -= buf;
            res++;
        }
        System.out.println(res);
    }
}