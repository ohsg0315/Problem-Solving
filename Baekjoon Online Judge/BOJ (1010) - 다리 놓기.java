import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(tokenizer.nextToken());
            int m = Integer.parseInt(tokenizer.nextToken());

            int res = 1, cnt = 1;
            while (cnt <= n) {
                res = res * (m--) / (cnt++);
            }
            System.out.println(res);
        }
    } // end of main
} // end of class