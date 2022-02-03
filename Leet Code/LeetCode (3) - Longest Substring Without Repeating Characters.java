import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;

        for (int i = 0, sLength = s.length(); i < sLength; i++) {
            if (map.containsKey(s.charAt(i))) {
                result = Math.max(result, map.size());
                i = map.get(s.charAt(i)) + 1;
                map.clear();
            }

            map.put(s.charAt(i), i);
        }
        return Math.max(result, map.size());
    }
}