class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        int low = 0, high = height.length - 1;

        while (low < high) {
            result = Math.max(result, (high - low) * Math.min(height[low], height[high]));

            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }

        return result;
    }
}