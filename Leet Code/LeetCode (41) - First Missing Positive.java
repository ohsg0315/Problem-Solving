class Solution {
    public int firstMissingPositive(int[] nums) {
        int index = 0, length = nums.length;

        while (index < length) {
            int cur = nums[index];

            if (cur <= 0 || cur >= length || nums[cur - 1] == cur) {
                index++;
                continue;
            }

            nums[index] = nums[cur - 1];
            nums[cur - 1] = cur;
        }

        for (int i = 0; i < length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return length + 1;
    }
}