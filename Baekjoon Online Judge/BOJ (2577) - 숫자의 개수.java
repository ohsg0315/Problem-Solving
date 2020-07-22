import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long res = 1;
        int[] number = new int[10];

        for (int i = 0; i < 3; i++) {
            res *= Long.parseLong(br.readLine());
        }

        while (res != 0) {
            number[(int) (res % 10)]++;
            res /= 10;
        }

        for (int i : number) {
            System.out.println(i);
        }

    } // end of main
} // end of class