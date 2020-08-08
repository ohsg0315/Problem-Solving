import java.awt.*;
import java.util.*;
import java.io.*;

/**
 *  TreeSet -> 많이 느림
 *  Arrays.binarySearch, lowerBound 함수 직접 구현 -> 같음
 *  Arrays.binarySearch 사용하자.
 */

public class Main {
    private static long[] lis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), length = 0;
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        lis = new long[n + 1];

        lis[0] = -1000000001;
        for (int i = 0; i < n; i++) {
            long cur = Long.parseLong(tokenizer.nextToken());

            if (lis[length] >= cur) {
                int idx = Arrays.binarySearch(lis, 0, length, cur);
                idx = idx < 0 ? -(idx + 1) : idx;
                lis[idx] = cur;
            } else {
                lis[++length] = cur;
            }
        }
        System.out.println(length);
    } // end of main
} // end of class