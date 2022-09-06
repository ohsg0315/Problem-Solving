class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0, length = nums.length;

        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        while (index < length) {
            nums[index++] = 0;
        }
    }
}