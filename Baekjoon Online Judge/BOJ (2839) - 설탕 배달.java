import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int weight = Integer.parseInt(br.readLine());
        int[] cache = new int[weight + 1];

        Arrays.fill(cache, -1);
        if (weight > 2) {
            cache[3] = 1;
        }
        if (weight > 4) {
            cache[5] = 1;
        }

        for (int i = 6; i <= weight; i++) {
//            둘 다 가능
            if (cache[i - 3] != -1 && cache[i - 5] != -1) {
                cache[i] = Math.min(cache[i - 3], cache[i - 5]) + 1;
            }
//            3Kg만 가능
            else if (cache[i - 3] != -1) {
                cache[i] = cache[i - 3] + 1;
            }
//            5Kg만 가능
            else if (cache[i - 5] != -1) {
                cache[i] = cache[i - 5] + 1;
            }
        }
        System.out.println(cache[weight]);
    } // end of main
} // end of class