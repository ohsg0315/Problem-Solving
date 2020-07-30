import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        TreeSet<Integer> ts = new TreeSet<>();

        ts.add(0);
        while (tokenizer.hasMoreTokens()) {
            int buf = Integer.parseInt(tokenizer.nextToken());

            if (ts.last() > buf) {
                ts.remove(ts.ceiling(buf));
            }
            ts.add(buf);
        }
        System.out.println(ts.size() - 1);
    } // end of main
} // end of class