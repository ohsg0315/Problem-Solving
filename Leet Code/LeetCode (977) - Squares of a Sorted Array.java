import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public int[] sortedSquares_001(int[] nums) {
        Stack<Integer> negative = new Stack<>();
        List<Integer> positive = new ArrayList<>();

        for (int num : nums) {
            if (num < 0) {
                negative.push(num * num);
            } else {
                positive.add(num * num);
            }
        }

        int index = 0;
        for (int num : positive) {
            while (!negative.isEmpty() && num > negative.peek()) {
                nums[index++] = negative.pop();
            }

            nums[index++] = num;
        }

        while (!negative.isEmpty()) {
            nums[index++] = negative.pop();
        }

        return nums;
    }

    public int[] sortedSquares_002(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] result = new int[right + 1];

        for (int index = right; index >= 0; index--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[index] = nums[left] * nums[left];
                left++;
            } else {
                result[index] = nums[right] * nums[right];
                right--;
            }
        }

        return result;
    }
}