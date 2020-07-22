import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        int hour = Integer.parseInt(tokenizer.nextToken());
        int minute = Integer.parseInt(tokenizer.nextToken());

        if (minute < 45) {
            minute += 60;
            if (hour < 1) {
                hour = 24;
            }
            hour -= 1;
        }
        minute -= 45;

        System.out.println(hour + " " + minute);
    } // end of main
} // end of class