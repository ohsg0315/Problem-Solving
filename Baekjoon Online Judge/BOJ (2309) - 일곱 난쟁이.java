import java.util.*;
import java.io.*;

public class Main {
    private static boolean flag;
    private static int[] list, comb;


    private static void Combination(int idx, int cnt) {
        if (cnt == 7) {
            int total = 0;
            for (int i : comb) {
                total += i;
            }

            if (total == 100) flag = true;
            return;
        }
        for (int i = idx; i < 9; i++) {
            comb[cnt] = list[i];
            Combination(i + 1, cnt + 1);

            if (flag) return;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        list = new int[9];
        comb = new int[7];

        for (int i = 0; i < 9; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        Combination(0, 0);
        Arrays.sort(comb);

        for (int i : comb)
            System.out.println(i);
    } // end of main
} // end of class