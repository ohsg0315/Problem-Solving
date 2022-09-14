import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring_001(String s) {
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

        public int lengthOfLongestSubstring_002(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int low = 0, high = 0, sLength = s.length();
        int res = 0;

        while (high < sLength) {
            char c = s.charAt(high);

            if (map.containsKey(c) && map.get(c) > 0) {
                res = Math.max(res, high - low );

                char cc =  s.charAt(low++);;
                map.put(cc, map.get(cc) - 1);

                while (cc != c) {
                    cc = s.charAt(low++);
                    map.put(cc, map.get(cc) - 1);
                }
            }

            high++;
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        return Math.max(res, high - low);
    }
}