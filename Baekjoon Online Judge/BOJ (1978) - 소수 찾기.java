import java.io.*;
import java.util.*;

public class Main {
    private static boolean isPrime(int number) {
        if (number == 1) return false;

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        int N = Integer.parseInt(br.readLine()), res = 0;
        int[] list = new int[N];
        tokenizer = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(tokenizer.nextToken());
        }

        for (int number : list) {
            if (isPrime(number)) res++;
        }

        System.out.println(res);
    } // end of main
}