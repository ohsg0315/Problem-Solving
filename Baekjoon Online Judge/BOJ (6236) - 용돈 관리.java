import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        long low = 0, high = 0, res = 0;
        int[] day = new int[n];
        for (int i = 0; i < n; i++) {
            day[i] = Integer.parseInt(br.readLine());
            high += day[i];
        }

        while (low <= high) {
            int cnt = 1;
            boolean flag = false;
            long mid = (low + high) / 2, cur = mid;

            for (int today : day) {
                // 뽑은 돈이 하루도 못쓰면 ㄴ
                if (mid < today) {
                    flag = true;
                    break;
                }
                if (cur - today < 0) {
                    cnt++;
                    cur = mid;
                }
                cur -= today;
            }
            if (flag) {
                low = mid + 1;
            } else if (cnt > m) {
                low = mid + 1;
            } else {
                res = mid;
                high = mid - 1;
            }
        }
        System.out.println(res);
    } // end of main
} // end of class