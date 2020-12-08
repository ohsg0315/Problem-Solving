import java.io.*;
import java.util.*;

public class Main {
    private static final int DIV = 10_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cache = new int[n + 1];

        cache[0] = 1;
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            cache[i] = (cache[i - 1] + cache[i - 2]) % DIV;
        }

        System.out.println(cache[n]);
    } // end of main
}