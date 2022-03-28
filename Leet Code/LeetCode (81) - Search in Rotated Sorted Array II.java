class Solution {
    public boolean search(int[] nums, int target) {
        for (int number : nums) {
            if (number == target) {
                return true;
            }
        }
        return false;
    }
}