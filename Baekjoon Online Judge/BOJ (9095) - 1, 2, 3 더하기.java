import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        int[] cache = new int[11];
        cache[1] = 1;
        cache[2] = 2;
        cache[3] = 4;
        for (int i = 4; i < 11; i++) {
            cache[i] = cache[i - 1] + cache[i - 2] + cache[i - 3];
        }
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(cache[n]).append('\n');
        }
        System.out.print(sb.toString());
    } // end of main
} // end of class