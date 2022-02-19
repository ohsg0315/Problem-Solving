import java.util.Arrays;

class Solution {
    public int removeDuplicates(int[] nums) {
        boolean moreThanTwo = false;
        int before = Integer.MIN_VALUE, result = 0;

        for (int i = 0, length = nums.length; i < length; i++) {
            result++;
            if (before == nums[i]) {
                if (moreThanTwo) {
                    result--;
                    nums[i] = Integer.MAX_VALUE;
                }
                moreThanTwo = true;
            }else {
                before = nums[i];
                moreThanTwo = false;
            }
        }

        Arrays.sort(nums);

        return result;
    }
}