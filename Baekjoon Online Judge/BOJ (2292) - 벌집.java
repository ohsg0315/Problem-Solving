import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int a = 1, res = 1;

        while (true) {
            if (N <= a) {
                break;
            }
            a += 6 * res++;
        }
        System.out.println(res);
    }
}