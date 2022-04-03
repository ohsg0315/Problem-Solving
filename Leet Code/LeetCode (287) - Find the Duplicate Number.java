class Solution {
    public int findDuplicate(int[] nums) {
        int idx = -1;

        for (int i = 0, length = nums.length; i < length; i++) {
            idx = Math.abs(nums[i]);

            if (nums[idx] < 0) {
                return idx;
            }

            nums[idx] *= -1;
        }

        return idx;
    }
}