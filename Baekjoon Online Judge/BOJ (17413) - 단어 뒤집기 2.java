import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(), buffer = new StringBuilder();
        String original = br.readLine();
        char c;

        for (int i = 0, length = original.length(); i < length; i++) {
            c = original.charAt(i);

            if (c == '<') {
                while (c != '>') {
                    sb.append(c);
                    c = original.charAt(++i);
                }
                sb.append(c);
            } else {
                buffer.setLength(0);
                while (c != ' ' && c != '<') {
                    buffer.insert(0, c);

                    if (i + 1 == length) break;

                    c = original.charAt(++i);
                }
                sb.append(buffer);

                if (c == ' ')
                    sb.append(c);
                else if(c == '<')
                    i--;
            }
        }
        System.out.println(sb.toString());
    } // end of main
} // end of class