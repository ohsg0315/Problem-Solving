import java.util.*;
import java.io.*;

public class Solution {
    public String solution(int n) {
        int remain;
        int[] arr = {4, 1, 2};
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            remain = n % 3;
            n /= 3;

            sb.insert(0, arr[remain]);

            if (remain == 0) n--;
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        System.out.println(solution.solution(21));
    }
}