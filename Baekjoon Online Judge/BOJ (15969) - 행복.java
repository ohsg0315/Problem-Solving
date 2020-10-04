import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(tokenizer.nextToken());

            max = Math.max(max, cur);
            min = Math.min(min, cur);
        }
        System.out.println(max - min);
    }
}