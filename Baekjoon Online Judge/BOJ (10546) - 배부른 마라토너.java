import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            hm.put(name, hm.getOrDefault(name, 0) + 1);
        }
        for (int i = 0; i < n - 1; i++) {
            String name = br.readLine();
            hm.put(name, hm.get(name) - 1);
        }

        for (Map.Entry<String, Integer> entry : hm.entrySet()) {
            if (entry.getValue() != 0) {
                System.out.println(entry.getKey());
                break;
            }
        }
    } // end of main
} // end of class