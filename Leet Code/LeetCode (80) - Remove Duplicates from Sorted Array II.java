import java.util.Arrays;

class Solution {
    // 4ms
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

    // 1ms
    // Snowball technique
    public int removeDuplicates(int[] nums) {
        int before = nums[0], duplicates = 0, result = 1;
        boolean moreThanTwo = false;

        for (int i = 1, length = nums.length; i < length; i++) {
            int cur = nums[i];
            if (before == cur) {
                if (moreThanTwo) {
                    duplicates++;
                } else {
                    result++;
                    nums[i - duplicates] = cur;
                    moreThanTwo = true;
                }
            }else {
                nums[i] = 0;
                nums[i - duplicates] = cur;
                before = cur;
                moreThanTwo = false;
                result++;
            }
        }

        return result;
    }
}