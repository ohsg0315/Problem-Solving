import java.io.*;
import java.util.*;

public class Main {
    private static int res, n, k, selected;
    private static String[] words;

    private static int find() {
        int total = 0;

        for (String word : words) {
            boolean flag = true;
            for (int i = 0, length = word.length(); i < length; i++) {
                int index = word.charAt(i) - 'a' + 1;
                if ((selected & (1 << index)) == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                total++;
        }
        return total;
    }

    private static void dfs(int cur, int cnt) {
        if (k == cnt) {
            res = Math.max(res, find());
            return;
        }

        for (int i = cur; i <= 26; i++) {
            if ((selected & (1 << i)) == 0) {
                selected |= (1 << i);
                dfs(i + 1, cnt + 1);
                selected ^= (1 << i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(tokenizer.nextToken());
        k = Integer.parseInt(tokenizer.nextToken());
        words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
            words[i] = words[i].substring(4, words[i].length() - 4);
        }

        if (k < 5)
            System.out.println(res);
        else if (k == 26)
            System.out.println(n);
        else {
            selected |= (1 << 1); // 'a'
            selected |= (1 << 'n' - 'a' + 1);
            selected |= (1 << 't' - 'a' + 1);
            selected |= (1 << 'i' - 'a' + 1);
            selected |= (1 << 'c' - 'a' + 1);

            dfs('b' - 'a' + 1, 5);
            System.out.println(res);
        }
    } // end of main
}