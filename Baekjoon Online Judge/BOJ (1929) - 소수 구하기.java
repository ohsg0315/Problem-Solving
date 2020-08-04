import java.util.*;
import java.io.*;

public class Main {
    private static boolean[] isPrime;

    private static boolean isPrimeNumber(int n) {
        if (isPrime[n]) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int from = Integer.parseInt(tokenizer.nextToken());
        int to = Integer.parseInt(tokenizer.nextToken());
        isPrime = new boolean[to + 1];

        if (from == 1) {
            from = 2;
        }
        for (int i = from; i <= to; i++) {
            if (isPrimeNumber(i)) {
                for (int j = i; j <= to; j += i) {
                    isPrime[j] = true;
                }
                sb.append(i).append("\n");
            }
        }
        System.out.print(sb.toString());
    } // end of main
} // end of class