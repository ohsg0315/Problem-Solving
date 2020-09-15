import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(tokenizer.nextToken());
        int w = Integer.parseInt(tokenizer.nextToken());
        int h = Integer.parseInt(tokenizer.nextToken());
        int l = Integer.parseInt(tokenizer.nextToken());

        int res = (w / l) * (h / l);
        res = (res < n) ? res : n;

        System.out.println(res);
    } // end of main
} // end of class