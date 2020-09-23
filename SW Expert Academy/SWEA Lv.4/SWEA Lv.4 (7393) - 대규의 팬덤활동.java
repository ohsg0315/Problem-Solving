import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int MOD = 1_000_000_000;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int[][][] cache = new int[101][10][1 << 10]; // [자리수][마지막 숫자][지금까지 사용한 숫자]

        for (int i = 1; i < 10; i++) { // 길이가 1인 수의 갯수, 0은 제외
            cache[1][i][1 << i] = 1;
        }
        for (int i = 2; i <= 100; i++) { // 길이가 2 ~ n 까지 bottom-up
            for (int j = 0; j < 10; j++) { // 마지막 숫자
                for (int k = 0; k < (1 << 10); k++) { // 비트마스크
                    int visited = k | (1 << j);
                    switch (j) {
                        case 0:
                            cache[i][j][visited] = (cache[i][j][visited] + cache[i - 1][j + 1][k]) % MOD;
                            break;
                        case 9:
                            cache[i][j][visited] = (cache[i][j][visited] + cache[i - 1][j - 1][k]) % MOD;
                            break;
                        default:
                            cache[i][j][visited] = ((cache[i][j][visited] + cache[i - 1][j - 1][k]) % MOD + cache[i - 1][j + 1][k]) % MOD;
                            break;
                    }
                }
            }
        }

        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());

            int res = 0;
            for (int i = 0; i < 10; i++) {
                res = (res + cache[n][i][(1 << 10) - 1]) % MOD;
            }
            System.out.println("#" + testCase + " " + res);
        } // end of testCase
    } // end of main
} // end of class