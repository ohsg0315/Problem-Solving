import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0, length = s.length(); i < length; i++) {
            char parenthesis = s.charAt(i);

            if (stack.isEmpty()) {
                stack.push(parenthesis);
            } else {
                char peek = stack.peek();
                switch (parenthesis) {
                    case ')':
                        if (stack.peek() == '(') {
                            stack.pop();
                        } else {
                            stack.push(parenthesis);
                        }
                        break;
                    case '}':
                        if (peek == '{') {
                            stack.pop();
                        } else {
                            stack.push(parenthesis);
                        }
                        break;
                    case ']':
                        if (peek == '[') {
                            stack.pop();
                        } else {
                            stack.push(parenthesis);
                        }
                        break;
                    default:
                        stack.push(parenthesis);
                }
            }
        } // end of for

        return stack.isEmpty();
    }
}