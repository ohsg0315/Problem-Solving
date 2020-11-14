import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        label:
        while (true) {
            int odd = 0;
            sb.setLength(0);
            String s = br.readLine().toLowerCase();

            for (int i = 0, len = s.length(); i < len; i++) {
                char c = s.charAt(i);

                if (c == '#') break label;

                if (c == 'e') {
                    if (odd % 2 == 0) sb.append('0');
                    else sb.append('1');
                } else if (c == 'o') {
                    if (odd % 2 == 0) sb.append('1');
                    else sb.append('0');
                } else {
                    if (c == '1')
                        odd++;
                    sb.append(c);
                }
            }
            System.out.println(sb.toString());
        }
    }
}