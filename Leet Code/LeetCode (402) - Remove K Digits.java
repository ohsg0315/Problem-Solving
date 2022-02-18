import java.util.Stack;

class Solution {
    public static String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0, length = num.length(); i < length; i++) {
            char c = num.charAt(i);
            while (!stack.isEmpty() && stack.peek() > c && k > 0) {
                k--;
                stack.pop();
            }
            stack.push(c);
        }

        while (k > 0) {
            k--;
            stack.pop();
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        int index = 0, length = result.length();
        result = result.reverse();
        while (index < length && result.charAt(index) == '0') {
            index++;
        }

        if (index == length) {
            return "0";
        }

        return result.substring(index);
    }
}