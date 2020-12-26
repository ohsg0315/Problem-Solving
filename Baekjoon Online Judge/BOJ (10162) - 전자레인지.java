import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        sb.append(T / 300).append(' ');
        T %= 300;
        sb.append(T / 60).append(' ');
        T %= 60;
        sb.append(T / 10).append('\n');

        if (T % 10 != 0) {
            sb.setLength(0);
            sb.append(-1).append('\n');
        }
        System.out.print(sb.toString());
    } // end of main
} // end of class