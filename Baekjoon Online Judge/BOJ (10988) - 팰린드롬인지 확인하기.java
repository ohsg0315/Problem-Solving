import java.util.*;
import java.io.*;

public class Main {
    private static int isPalindrome(String s) {
        int low = 0, high = s.length() - 1;

        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) return 0;
            low++;
            high--;
        }
        return 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.print(isPalindrome(s));
    }
}