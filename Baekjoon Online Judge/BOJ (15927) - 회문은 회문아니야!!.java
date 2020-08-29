import java.util.*;
import java.io.*;

public class Main {
    private static int res = -1;

    private static boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String original = br.readLine();
        int length = original.length();

        // 전체가 회문이 아니면 답
        if (!isPalindrome(original))
            res = length;
        else {
            // 전체가 회문일 경우 문자열이 같은 문자로 이루어진 경우, 아닌경우만 체크
            // 문자열이 같은 문자로 이루어진 경우 res = -1
            if (isPalindrome(original.substring(0, length - 1))) {
                res = -1;
            }
            // 아닌 경우
            else {
                res = length - 1;
            }
        }
        System.out.println(res);
    } // end of main
} // end of class