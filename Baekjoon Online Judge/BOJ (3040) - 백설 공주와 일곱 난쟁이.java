import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static boolean flag;
    private static int[] arr, comb;
    
    private static void combination(int idx, int cnt){
        if(cnt == 7){
            int total = 0;
            for (int i = 0; i < 7; i++) {
                total += arr[comb[i]];
            }
            if(total == 100){
                for (int i = 0; i < 7; i++) {
                    System.out.println(arr[comb[i]]);
                }
                flag = true;
            }
            return;
        }

        for (int i = idx; i < 9; i++) {
            comb[cnt] = i;
            combination(i + 1, cnt + 1);

            if(flag) return;
        }
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[9];
        comb = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        combination(0, 0);
    }
}