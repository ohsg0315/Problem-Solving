import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        int k = Integer.parseInt(br.readLine());
        tokenizer = new StringTokenizer(br.readLine(), " ");

        int d1 = Integer.parseInt(tokenizer.nextToken());
        int d2 = Integer.parseInt(tokenizer.nextToken());

        if (d1 == d2)
            System.out.println(k * k);
        else if (d1 == d2 * 3) {
            double res = Math.pow(k, 2) - Math.pow((d1 - d2) / 2.0, 2);
            System.out.println((int) res);
        } else {
            double res = Math.pow(k, 2) - Math.pow((d1 - d2) / 2.0, 2);
            System.out.println(res);
        }
    } // end of main
}