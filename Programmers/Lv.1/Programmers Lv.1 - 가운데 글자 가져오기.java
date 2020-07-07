import java.util.*;

public class Solution {
    public String solution(String s) {
        if (s.length() % 2 == 0) {
            return s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
        } else {
            return s.charAt(s.length() / 2) + "";
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("abcde"));
    }
}
