class Solution {
    public int[] buildArray(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0, length = nums.length; i < length; i++) {
            result[i] = nums[nums[i]];
        }

        return result;
    }
}