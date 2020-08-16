import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static boolean endFlag;
    private static StringBuilder sb;

    private static void goodSequence(int cnt) {
        if (cnt == n) {
            System.out.println(sb.toString());
            endFlag = true;
            return;
        }
        for (int i = 1; i < 4; i++) {
            sb.append(i);

            int end = sb.length();
            int mid = end / 2;
            boolean flag = true;

            // 좋은 수열 체크
            if (end - mid >= mid) {
                for (int j = 1; j <= mid; j++) {
                    if (sb.subSequence(end - j, end).equals(sb.subSequence(end - 2 * j, end - j))) {
                        flag = false;
                        break;
                    }
                }
            }
            // 좋은 수열이라면 진행
            if (flag) goodSequence(cnt + 1);

            // 최소값의 좋은 수열을 찾았다면 더이상 진행 X
            if (endFlag) return;

            // 백트래킹
            sb.delete(end - 1, end);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sb = new StringBuilder(n);
        endFlag = false;
        goodSequence(0);
    } // end of main
} // end of class