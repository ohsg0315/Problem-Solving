import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int total = 0, result = 0;
        Map<Integer, Integer> sum = new HashMap<>();

        sum.put(0, 1);
        for (int i = 0, length = nums.length; i < length; i++) {
            total += nums[i];

            //total - key = k  --> total - k = key
            if (sum.containsKey(total - k)) {
                result += sum.get(total - k);
            }
            sum.put(total, sum.getOrDefault(total, 0) + 1);
        }

        return result;
    }
}