import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            boolean flag = true;
            int n = Integer.parseInt(br.readLine());
            String[] numbers = new String[n];

            for (int i = 0; i < n; i++) {
                numbers[i] = br.readLine();
            }

            Arrays.sort(numbers);

            for (int i = 0; i < n - 1; i++) {
                if (numbers[i + 1].startsWith(numbers[i])) {
                    sb.append("NO\n");
                    flag = false;
                    break;
                }
            }
            if (flag)
                sb.append("YES\n");
        }
        System.out.println(sb.toString());
    } // end of main
} // end of class