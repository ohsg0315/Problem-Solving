import java.util.*;
import java.io.*;

public class Main {
    private static int N, r, c, cnt, res;
    private static boolean flag;

    private static void dq(int n, int x, int y) {
        if (flag) return;
        if (n == 1) {
            if (r == y && c == x) {
                res = cnt;
                flag = true;
            }
            cnt++;
            return;
        }
        if (r >= y + n || y > r || c >= x + n || x > c) {
            cnt += n * n;
            return;
        }
        dq(n / 2, x, y);
        dq(n / 2, x + n / 2, y);
        dq(n / 2, x, y + n / 2);
        dq(n / 2, x + n / 2, y + n / 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        N = 2 << Integer.parseInt(tokenizer.nextToken());
        r = Integer.parseInt(tokenizer.nextToken());
        c = Integer.parseInt(tokenizer.nextToken());

        dq(N, 0, 0);

        System.out.println(res);
    } // end of main
} // end of class`