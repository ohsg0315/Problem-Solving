import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        String n = tokenizer.nextToken();
        int m = Integer.parseInt(tokenizer.nextToken());
        StringBuilder sb = new StringBuilder();

        if (n.length() > m) {
            System.out.println(n.substring(0, m));
        } else {
            boolean flag = true;
            for (int i = 0, size = Integer.parseInt(n); i < size; i++) {
                if (sb.length() + n.length() > m) {
                    flag = false;
                    break;
                }

                sb.append(n);
            }
            if (!flag) {
                int diff = m - sb.length();
                sb.append(n.substring(0, diff));
            }
        }
        System.out.println(sb.toString());
    }
}