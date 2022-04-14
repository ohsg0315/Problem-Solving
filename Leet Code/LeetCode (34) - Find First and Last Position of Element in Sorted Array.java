import java.util.Arrays;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int idx = Arrays.binarySearch(nums, target);

        if (idx < 0) {
            return new int[]{-1, -1};
        }

        int start = idx, end = idx;

        while (1 <= start && nums[start - 1] == target) {
            start--;
        }

        while (end + 1 < nums.length && nums[end + 1] == target) {
            end++;
        }

        return new int[]{start, end};
    }
}