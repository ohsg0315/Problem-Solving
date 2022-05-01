import java.util.Stack;

class Solution {

    private String build(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0, length = s.length(); i < length; i++) {
            if (s.charAt(i) != '#') {
                stack.push(s.charAt(i));
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }

        return stack.toString();
    }
    
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }
}