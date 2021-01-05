import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().toUpperCase();
        int[] selected = new int['Z' + 1];

        for (int i = 0, length = s.length(); i < length; i++) {
            selected[s.charAt(i)]++;
        }

        int max = -1, alpha = 'A' - 1;
        boolean duple = false;

        for (int i = 'A'; i <= 'Z'; i++) {
            if (selected[i] > max) {
                duple = false;
                alpha = i;
                max = selected[i];
            } else if (selected[i] == max) {
                duple = true;
            }
        }

        if (duple) {
            System.out.println('?');
        } else {
            System.out.println((char) alpha);
        }
    } // end of main
} // end of class