import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Character> set = new HashSet<>();

        label:
        while (true) {
            set.clear();
            String s = br.readLine().toLowerCase();

            for (int i = 0, len = s.length(); i < len; i++) {
                char c = s.charAt(i);

                if (c == '#') break label;

                if ('a' <= c && c <= 'z') set.add(c);
            }
            System.out.println(set.size());
        }

    }
}