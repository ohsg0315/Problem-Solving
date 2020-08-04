import java.util.*;
import java.io.*;

public class Main {
    private static int N, major, minor;
    private static int[] test;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        N = Integer.parseInt(br.readLine());
        test = new int[N];

        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            test[i] = Integer.parseInt(tokenizer.nextToken());
        }
        tokenizer = new StringTokenizer(br.readLine());
        major = Integer.parseInt(tokenizer.nextToken());
        minor = Integer.parseInt(tokenizer.nextToken());

        long res = N;
        for (int i = 0; i < N; i++) {
            // 총 시험감독관은 시험장마다 한명 필요
            test[i] -= major;

            // 부 시험감독관이 필요하면 투입
            if (test[i] > 0) {
                res += Math.ceil((double) test[i] / minor);
            }
        }
        System.out.println(res);
    } // end of main
} // end of class