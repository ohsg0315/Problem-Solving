import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        HashMap<String, Integer> hm = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();


        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            hm.put(s, hm.getOrDefault(s, 0) + 1);
        }
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            hm.put(s, hm.getOrDefault(s, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : hm.entrySet()) {
            if (entry.getValue() == 2) {
                list.add(entry.getKey());
            }
        }
        Collections.sort(list);

        System.out.println(list.size());
        for (String s : list) {
            System.out.println(s);
        }
    }
}