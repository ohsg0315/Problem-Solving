import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(list);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if(list[i] > cnt + 1) break;
            cnt += list[i];
        }
        System.out.println(cnt + 1);
    } // end of main
} // end of class