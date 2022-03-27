class Solution {
    private void reverse(int[] nums, int target) {
        int idx = nums.length - 1;

        while (target < idx) {
            int temp = nums[idx];
            nums[idx] = nums[target];
            nums[target] = temp;

            target++;
            idx--;
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void nextPermutation(int[] nums) {
        int idx = nums.length - 1;

        while (idx > 0 && nums[idx - 1] >= nums[idx]) {
            idx--;
        }

        if (idx > 0) {
            int target = idx;
            while (target < nums.length && nums[idx - 1] < nums[target]) {
                target++;
            }

            swap(nums, idx - 1, target - 1);
        }

        reverse(nums, idx);
    }
}