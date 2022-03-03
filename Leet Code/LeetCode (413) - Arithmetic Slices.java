class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int length = nums.length, result = 0;
        int[] cache = new int[length], subArray = new int[length + 1];

        if (length < 3) {
            return 0;
        }

        subArray[3] = 1;
        for (int i = 4; i < length + 1; i++) {
            subArray[i] = subArray[i - 1] + i - 2;
        }

        int head = 0, diff = nums[0] - nums[1];
        for (int i = 2; i < length; i++) {
            int curDiff = nums[i - 1] - nums[i];

            if (curDiff != diff) {
                cache[head] = i - 1;
                head = i - 1;

                diff = curDiff;
            }
        }

        if (cache[head] == 0) {
            cache[head] = length - 1;
        }

        for (int i = 0; i < length; i++) {
            int numOfConsecutive = cache[i] - i + 1;

            if (numOfConsecutive >= 3) {
                result += subArray[numOfConsecutive];
            }
        }

        return result;
    }
}