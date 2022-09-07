import java.util.Stack;

class Solution {
    public String reverseWords_001(String s) {
        StringBuilder result = new StringBuilder();
        String[] words = s.split(" ");

        for (String word : words) {
            result.append(reverse_001(word)).append(' ');
        }

        return result.toString().trim();
    }

    private String reverse_001(String word) {
        char[] chars = word.toCharArray();

        int left = 0, right = word.length() - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }

        return new String(chars);
    }

    public String reverseWords_002(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0, length = s.length(); i < length; i++) {
            char c = s.charAt(i);

            if (c == ' ') {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
                result.append(c);
            } else {
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }
}