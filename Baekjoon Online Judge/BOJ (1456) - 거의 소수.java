import java.util.*;
import java.io.*;

public class Main {
    private static long from, to, res;
    private static long[] prime;
    private static boolean[] notPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        from = Long.parseLong(tokenizer.nextToken());
        to = Long.parseLong(tokenizer.nextToken());

        // 거의 소수 => 제곱근 까지만 소수 판별하면 된다
        int cnt = 0;
        long maxPrime = (int) Math.sqrt(to);

        // 에라토스테네스의 체
        prime = new long[(int) maxPrime + 1];
        notPrime = new boolean[(int) maxPrime + 1];
        notPrime[1] = true;

        for (int i = 2; i <= maxPrime; i++) {
            if (!notPrime[i]) {
                int next = i + i;
                prime[cnt++] = i;
                while (next <= maxPrime) {
                    notPrime[next] = true;
                    next += i;
                }
            }
        }

        // 거의 소수 카운트
        for (int i = 0; i < cnt; i++) {
            long cur = prime[i] * prime[i];
            long nextTo = to;
            boolean flag = false;

            while (cur <= nextTo) {
                if (from <= cur) {
                    res++;
                    flag = true;
                }

                // from 이상으로 올리기 위해서 소수 제곱하다가 오버플로우 방지용으로 nextTo 범위를 줄여나간다.
                if (flag) {
                    nextTo /= prime[i]; // cur * prime[i] <= nextTo   ==   cur <= nextTo / prime[i]
                } else {
                    cur *= prime[i];
                }
            }
        }
        System.out.println(res);
    } // end of main
} // end of class