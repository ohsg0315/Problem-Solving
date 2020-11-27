import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> hs = new HashSet<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            Arrays.sort(chars);

            String s = new String(chars);
            hs.add(s);
        }
        System.out.print(hs.size());
    } // end of main
}