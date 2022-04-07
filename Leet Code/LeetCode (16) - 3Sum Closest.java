import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = 0, diff = Integer.MAX_VALUE;

        Arrays.sort(nums);

        for (int i = 0, length = nums.length - 1; i < length; i++) {
            int low = i + 1, high = length;

            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];

                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    low++;
                } else {
                    high--;
                }

                if (Math.abs(target - sum) < diff) {
                    diff = Math.abs(target - sum);
                    result = sum;
                }
            }
        }
        return result;
    }
}