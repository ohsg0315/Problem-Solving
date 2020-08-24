import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        int n = Integer.parseInt(br.readLine()), res = 0;
        int[] a = new int[n], b = new int[n];


        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(tokenizer.nextToken());
        }
        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < n; i++) {
            res += a[i] * b[n - 1 - i];
        }
        System.out.println(res);
    } // end of main
} // end of class`