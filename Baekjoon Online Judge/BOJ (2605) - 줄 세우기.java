import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        int n = Integer.parseInt(br.readLine());
        int[] order = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        tokenizer = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            order[i] = Integer.parseInt(tokenizer.nextToken());
        }

        for (int i = 0; i < n; i++) {
            list.add(i - order[i], i + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i : list) {
            sb.append(i).append(' ');
        }

        System.out.println(sb.toString().trim());
    } // end of main
} // end of class