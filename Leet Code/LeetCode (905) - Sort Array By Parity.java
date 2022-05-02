class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int cur = nums[low];

            if (cur % 2 == 0) {
                low++;
            } else {
                nums[low] = nums[high];
                nums[high--] = cur;
            }
        }
        return nums;
    }
}