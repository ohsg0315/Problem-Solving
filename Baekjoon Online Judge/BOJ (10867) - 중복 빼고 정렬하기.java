import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Integer> ts = new TreeSet<>();
        br.readLine();
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        while (tokenizer.hasMoreTokens()) {
            ts.add(Integer.parseInt(tokenizer.nextToken()));
        }

        Iterator<Integer> iter = ts.iterator();
        StringBuilder sb = new StringBuilder();
        while (iter.hasNext()) {
            sb.append(iter.next()).append(" ");
        }
        System.out.println(sb.toString().trim());
    } // end of main
} // end of class