import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findPairs(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //Case: k = 0
        if (k == 0) {
            for (int value : map.values()) {
                if (value > 1) {
                    result++;
                }
            }
        }
        //Case: k > 0
        else {
            for (int value : map.keySet()) {
                if (map.containsKey(value - k)) {
                    result++;
                }
            }
        }
        return result;
    }
}