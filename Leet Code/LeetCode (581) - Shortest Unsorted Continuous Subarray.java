import java.util.Stack;

public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int idx = 0, low = nums.length, high = 0;
        Stack<Integer> stack = new Stack<>();

        while (idx < nums.length) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[idx]) {
                low = Math.min(low, stack.pop());
            }
            stack.push(idx++);
        }

        stack.clear();
        idx = nums.length - 1;
        while (0 <= idx) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[idx]) {
                high = Math.max(high, stack.pop());
            }
            stack.push(idx--);
        }

        return high - low > 0 ? high - low + 1 : 0;
    }
}