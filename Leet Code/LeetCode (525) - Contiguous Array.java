import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findMaxLength(int[] nums) {
        int total = 0, result = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int index = 0, length = nums.length; index < length; index++) {
            int number = nums[index] == 1 ? 1 : -1;

            total += number;
            if (!map.containsKey(total)) {
                map.put(total, index);
            }

            if (total == 0) {
                result = Math.max(result, index + 1);
            }
            else if (map.containsKey(total)) {
                result = Math.max(result, index - map.get(total));
            }
        }

        return result;
    }
}