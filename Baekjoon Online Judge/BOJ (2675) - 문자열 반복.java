import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            int loop = Integer.parseInt(tokenizer.nextToken());
            String s = tokenizer.nextToken();

            for (int i = 0, length = s.length(); i < length; i++) {
                for (int j = 0; j < loop; j++) {
                    sb.append(s.charAt(i));
                }
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    } // end of main
}