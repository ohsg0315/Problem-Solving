import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;

        for (int i = 0; i < 5; i++) {
            int score = Integer.parseInt(br.readLine());

            if (score < 40) {
                score = 40;
            }
            sum += score;
        }
        System.out.println(sum / 5);
    } // end of main
} // end of class