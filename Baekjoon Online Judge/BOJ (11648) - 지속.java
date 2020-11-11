import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int res = 0;

        while (n / 10 != 0) {
            res++;
            int buf = 1;

            while (n != 0) {
                buf *= (n % 10);
                n /= 10;
            }
            n = buf;
        }
        System.out.println(res);
    }
}