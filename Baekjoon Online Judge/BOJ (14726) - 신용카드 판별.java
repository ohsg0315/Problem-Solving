import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int res = 0;
            String s = br.readLine();

            for (int i = 0, len = s.length(); i < len; i++) {
                if (i % 2 == 0) {
                    int buf = (s.charAt(i) - '0') * 2;

                    if (buf >= 10) {
                        res++;
                        res += buf % 10;
                    } else {
                        res += buf;
                    }
                } else {
                    res += s.charAt(i) - '0';
                }
            }
            if (res % 10 == 0)
                sb.append('T').append('\n');
            else
                sb.append('F').append('\n');
        }
        System.out.print(sb.toString());
    } // end of main
}