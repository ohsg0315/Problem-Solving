import java.util.*;
import java.io.*;

public class Main {
    private static int n, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int low = 0, high = 1;

        while (high <= n) {
            int buf = high * (high + 1) - low * (low + 1);
            buf /= 2;

            if (buf == n) {
                res++;
                high++;
            } else if (buf < n) {
                high++;
            } else {
                low++;
            }
        }
        System.out.println(res);
    } // end of main
} // end of class