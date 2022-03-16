import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int length = pushed.length, index = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            if (stack.isEmpty()) {
                stack.push(pushed[i]);
            } else {
                if (stack.peek() == popped[index]) {
                    stack.pop();
                    index++;
                    i--;
                }else {
                    stack.push(pushed[i]);
                }
            }
        }

        for (int i = index; i < length; i++) {
            if (stack.isEmpty() || stack.peek() != popped[i]) {
                break;
            }
            stack.pop();
        }

        return stack.isEmpty();
    }
}