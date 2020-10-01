import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int total = 0;

            tokenizer = new StringTokenizer(br.readLine(), " ");
            while (tokenizer.hasMoreTokens()) {
                total += Integer.parseInt(tokenizer.nextToken());
            }
            System.out.println(total);
        }
    }
}