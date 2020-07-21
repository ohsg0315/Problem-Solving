import java.util.*;
import java.io.*;

public class Main {
    private static int[] cache;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int initNumber = Integer.parseInt(br.readLine());

        cache = new int[initNumber + 1];
        cache[1] = 0;

        for (int i = 2; i <= initNumber; i++) {
            // 3과 2로 모두 나뉘는 경우
            if (i % 3 == 0 && i % 2 == 0) {
                cache[i] = Math.min(cache[i / 3], Math.min(cache[i / 2], cache[i - 1])) + 1;
            }
            // 3으로만 나뉘는 경우
            else if (i % 3 == 0) {
                cache[i] = Math.min(cache[i / 3], cache[i - 1]) + 1;
            }
            // 2로만 나뉘는 경우
            else if (i % 2 == 0) {
                cache[i] = Math.min(cache[i / 2], cache[i - 1]) + 1;
            }
            // 둘다 아닌 경우
            else {
                cache[i] = cache[i - 1] + 1;
            }
        }
        System.out.println(cache[initNumber]);
    } // end of main
} // end of class