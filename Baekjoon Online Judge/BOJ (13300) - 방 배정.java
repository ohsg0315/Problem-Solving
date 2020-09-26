import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        HashMap<Integer, Integer> man = new HashMap<>(), woman = new HashMap<>();

        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");

            int s = Integer.parseInt(tokenizer.nextToken());
            int grade = Integer.parseInt(tokenizer.nextToken());

            if (s == 0) {
                woman.put(grade, woman.getOrDefault(grade, 0) + 1);
            } else if (s == 1) {
                man.put(grade, man.getOrDefault(grade, 0) + 1);
            }
        }
        int res = 0;
        for (int i = 1; i <= 6; i++) {
            if (man.containsKey(i)) {
                int cur = man.get(i);

                if (cur % k == 0) {
                    res += cur / k;
                } else {
                    res += cur / k + 1;
                }
            }
            if (woman.containsKey(i)) {
                int cur = woman.get(i);

                if (cur % k == 0) {
                    res += cur / k;
                } else {
                    res += cur / k + 1;
                }
            }
        }
        System.out.println(res);
    }
}