import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] alpha = new int[26];
        for (int i = 0, length = s.length(); i < length; i++) {
            alpha[s.charAt(i) - 'a']++;
        }

        Set<Character> used = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0, length = s.length(); i < length; i++) {
            char c = s.charAt(i);

            if (used.contains(c)) {
                alpha[c - 'a']--;
                continue;
            }

            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek() > c && alpha[stack.peek() - 'a'] > 0) {
                    used.remove(stack.pop());
                }
            }

            stack.push(c);
            used.add(c);
            alpha[c - 'a']--;
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }
}