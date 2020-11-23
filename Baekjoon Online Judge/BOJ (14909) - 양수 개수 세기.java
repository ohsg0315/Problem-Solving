import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        int res = 0;
        while (tokenizer.hasMoreTokens()) {
            char c = tokenizer.nextToken().charAt(0);
            if (c != '-' && c != '0') res++;
        }
        System.out.println(res);
    } // end of main
}