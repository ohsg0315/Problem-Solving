import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer>[] friends = new ArrayList[n + 1];

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());

            if (friends[a] == null) {
                friends[a] = new ArrayList<>();
            }
            if (friends[b] == null)
                friends[b] = new ArrayList<>();

            friends[a].add(b);
            friends[b].add(a);
        }
        for (int i = 0, length = friends[1].size(); i < length; i++) {
            int friend = friends[1].get(i);
            set.add(friend);

            for (int j = 0, len = friends[friend].size(); j < len; j++) {
                set.add(friends[friend].get(j));
            }
        }
        System.out.println(set.size() - 1);
    } // end of main
} // end of class