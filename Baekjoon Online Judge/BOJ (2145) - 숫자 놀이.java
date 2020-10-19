import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String num = br.readLine();

            if (num.equals("0")) break;
            if(num.length() == 1)
                System.out.println(num);
            while (num.length() != 1) {
                int total = 0;
                for (int i = 0; i < num.length(); i++) {
                    total += Integer.parseInt(num.charAt(i) + "");
                }
                if (total < 10) {
                    System.out.println(total);
                    break;
                }
                num = Integer.toString(total);
            }
        }
    } // end of main
}