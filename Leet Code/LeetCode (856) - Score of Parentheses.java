import java.util.Stack;

class Solution {
    public int scoreOfParentheses(String s) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0, length = s.length(); i < length; i++) {
            char c = s.charAt(i);

            if (stack.isEmpty() || c == '(') {
                stack.push(0);
            } else if (stack.peek() == 0) {
                stack.pop();
                stack.push(1);
            } else {
                int score = 0;

                while (!stack.isEmpty() && stack.peek() != 0) {
                    score += stack.pop();
                }

                stack.pop();
                stack.push(score * 2);
            }
        }

        for (Integer score : stack) {
            result += score;
        }

        return result;
    }
}