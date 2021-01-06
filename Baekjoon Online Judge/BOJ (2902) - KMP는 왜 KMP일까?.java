import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), "-");

        while (tokenizer.hasMoreTokens()) {
            sb.append(tokenizer.nextToken().charAt(0));
        }
        System.out.println(sb.toString());
    } // end of main
} // end of class