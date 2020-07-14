import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            int n = Integer.parseInt(br.readLine());

            // 테스트케이스 범위가 크기 때문에 long을 사용해야 한다.
            // 초항 a = 1, 공차 d = 2, 마지막 항 l = a + (n-1)d -> 등차수열의 합 = n(a + l) / 2
            long res = 0, a = 1, d = 2, l = a + (n / 2 - 1) * d;
            res = (n / 2) * (a + l) / 2;


            System.out.println("#" + testCase + " " + res);
        }
    }
}