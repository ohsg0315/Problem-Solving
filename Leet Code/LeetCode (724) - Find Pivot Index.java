class Solution {
    public int pivotIndex(int[] nums) {
        int leftSum = 0, rightSum = 0;

        for (int num : nums) {
            rightSum += num;
        }

        int remove = 0;
        for (int index = 0, length = nums.length; index < length; index++) {
            leftSum += remove;
            remove = nums[index];
            rightSum -= remove;

            if (leftSum == rightSum) {
                return index;
            }
        }

        return -1;
    }
}