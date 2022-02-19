import java.util.Arrays;

class Solution {
    public int removeDuplicates(int[] nums) {
        boolean moreThanTwo = false;
        int cur = Integer.MIN_VALUE, result = 0;

        for (int i = 0, length = nums.length; i < length; i++) {
            result++;
            if (cur == nums[i]) {
                if (moreThanTwo) {
                    result--;
                    nums[i] = Integer.MAX_VALUE;
                }
                moreThanTwo = true;
            }else {
                cur = nums[i];
                moreThanTwo = false;
            }
        }

        Arrays.sort(nums);

        return result;
    }
}