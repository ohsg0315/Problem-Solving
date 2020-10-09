import java.io.*;
import java.util.*;

class Solution {
    private static boolean[] isPrime;

    public int solution(int n) {
        int answer = 0;
        isPrime = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            if (!isPrime[i]) {
                answer++;
                for (int j = i + i; j <= n; j += i) {
                    isPrime[j] = true;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
    } // end of main
} // end of class
