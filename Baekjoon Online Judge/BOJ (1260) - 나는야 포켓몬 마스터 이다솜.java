import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(tokenizer.nextToken()), M = Integer.parseInt(tokenizer.nextToken());
        HashMap<String, String> hm = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            hm.put(i + "", name);
            hm.put(name, i + "");
        }
        for (int i = 0; i < M; i++) {
            String question = br.readLine();
            System.out.println(hm.get(question));
        }
    } // end of main
} // end of class