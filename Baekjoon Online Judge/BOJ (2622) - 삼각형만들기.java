import java.io.*;
import java.util.*;

public class Main {
    private static int findTriangle(int n) {
        int res = 0;
        for (int a = 1; a < n - 1; a++) {
            for (int b = a; b < n - 1; b++) {
                int c = n - a - b;

                if (c < b) break;
                else if (c < a + b) res++;
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(findTriangle(n));
    } // end of main
} // end of class