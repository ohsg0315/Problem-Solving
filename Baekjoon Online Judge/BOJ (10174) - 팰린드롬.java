import java.util.*;
import java.io.*;

public class Main {
    private static boolean isPalindrome(String s) {
        int lo = 0, hi = s.length() - 1;

        while (lo < hi) {
            if (s.charAt(lo++) != s.charAt(hi--)) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            s = s.toLowerCase();

            if (isPalindrome(s))
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
}