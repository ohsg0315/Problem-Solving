import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            HashMap<String, Integer> hm = new HashMap<>();
            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                tokenizer = new StringTokenizer(br.readLine(), " ");
                tokenizer.nextToken();
                String type = tokenizer.nextToken();
                hm.put(type, hm.getOrDefault(type, 0) + 1);
            }

            int res = 1;
            for (int i : hm.values()) {
                res *= (i + 1);
            }

            System.out.println(res - 1);
        }
    }
}