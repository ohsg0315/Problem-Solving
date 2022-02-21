import java.util.HashMap;
import java.util.Map;

class Solution {
    public int majorityElement(int[] nums) {
        int max = 0, result = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int number : nums) {
            map.put(number, map.getOrDefault(number, 0) + 1);

            if (map.get(number) > max) {
                max = map.get(number);
                result = number;

                if (max > nums.length / 2) {
                    return result;
                }
            }
        }
        return result;
    }
}