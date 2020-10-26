import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        Queue<Integer> qu = new LinkedList<>();

        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            qu.offer(i);
        }

        sb.append('<');
        while(!qu.isEmpty()){
            for (int i = 1; i < K; i++) {
                qu.offer(qu.poll());
            }
            sb.append(qu.poll()).append(',').append(' ');
        }
        sb.deleteCharAt(sb.length() -1 );
        sb.deleteCharAt(sb.length() - 1);
        sb.append('>');

        System.out.println(sb.toString());
    } // end of main
} // end of class