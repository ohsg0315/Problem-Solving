import java.util.*;
import java.io.*;

public class Main {
    private static boolean flag;
    private static int n, k, cnt;
    private static ArrayList<Integer> list;
    private static StringBuilder sb;

    private static void dfs(int total) {
        if (total == n) {
            cnt++;

            if (cnt == k) {
                for (int i = 0; i < list.size(); i++) {
                    sb.append(list.get(i)).append('+');
                }
                sb.deleteCharAt(sb.length() - 1);
                flag = true;
            }
            return;
        }
        for (int i = 1; i < 4; i++) {
            if (total + i <= n) {
                list.add(i);
                dfs(total + i);
                list.remove(list.size() - 1);
            }
            if (flag) return;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(tokenizer.nextToken());
        k = Integer.parseInt(tokenizer.nextToken());
        list = new ArrayList<>();
        sb = new StringBuilder();

        dfs(0);

        if (flag)
            System.out.println(sb.toString());
        else
            System.out.println("-1");
    } // end of main
} // end of class