class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0, length = nums.length;

        for (int i = length - 1; i >= 0; i--) {
            if (nums[i] != val) {
                break;
            }

            length--;
        }

        while (index < length) {
            int number = nums[index];

            if (number == val) {
                nums[index] = nums[length - 1];
                nums[length - 1] = number;
                length--;
            } else {
                index++;
            }
        }

        return length;
    }
}