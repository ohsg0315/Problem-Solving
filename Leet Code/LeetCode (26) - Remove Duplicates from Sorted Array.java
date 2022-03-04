class Solution {
    public int removeDuplicates(int[] nums) {
        int before = nums[0], duplicates = 0, result = 1;

        for (int i = 1, length = nums.length; i < length; i++) {
            int cur = nums[i];
            if (before == cur) {
                duplicates++;
            }else {
                nums[i] = 0;
                nums[i - duplicates] = cur;
                before = cur;
                result++;
            }
        }

        return result;
    }
}