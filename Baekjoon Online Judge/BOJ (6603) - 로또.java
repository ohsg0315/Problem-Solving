import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int[] lotto;
    private static ArrayList<Integer> numbers;
    private static StringBuilder sb;

    private static void combination(int idx, int cnt) {
        if (cnt == 6) {
            sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                sb.append(numbers.get(i)).append(" ");
            }
            System.out.println(sb.toString().trim());
            return;
        }

        for (int i = idx; i < n; i++) {
            numbers.add(lotto[i]);
            combination(i + 1, cnt + 1);
            numbers.remove(cnt);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        while (true) {
            tokenizer = new StringTokenizer(br.readLine());
            n = Integer.parseInt(tokenizer.nextToken());

            if (n == 0)
                break;

            lotto = new int[n];
            sb = new StringBuilder();
            numbers = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                lotto[i] = Integer.parseInt(tokenizer.nextToken());
            }
            combination(0, 0);
            System.out.println();
        }
    } // end of main
} // end of class