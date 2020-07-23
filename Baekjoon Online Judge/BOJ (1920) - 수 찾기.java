import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        HashMap<Integer, Integer> hm = new HashMap<>();

        while (tokenizer.hasMoreTokens()) {
            hm.put(Integer.parseInt(tokenizer.nextToken()), 1);
        }

        int M = Integer.parseInt(br.readLine());
        tokenizer = new StringTokenizer(br.readLine(), " ");
        while (tokenizer.hasMoreTokens()) {
            int buf = Integer.parseInt(tokenizer.nextToken());
            if (hm.containsKey(buf)) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    } // end of main
} // end of class