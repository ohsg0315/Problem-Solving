import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(tokenizer.nextToken()), X = Integer.parseInt(tokenizer.nextToken());
        tokenizer = new StringTokenizer(br.readLine(), " ");

        while (tokenizer.hasMoreTokens()) {
            int bufNumber = Integer.parseInt(tokenizer.nextToken());
            if (bufNumber < X) {
                sb.append(bufNumber + " ");
            }
        }
        System.out.println(sb.toString().toString());
    } // end of main
} // end of class