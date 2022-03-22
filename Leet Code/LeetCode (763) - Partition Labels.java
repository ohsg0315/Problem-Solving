import java.util.*;

class Solution {
    public List<Integer> partitionLabels(String s) {
        int low = 0, high = 0, length = s.length();
        Set<Character> set = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);

            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        while (high < length) {
            char c = s.charAt(high);
            map.put(c, map.get(c) - 1);

            if (map.get(c) == 0) {
                boolean isPartition = true;

                for (char cc : set) {
                    if (map.get(cc) != 0) {
                        isPartition = false;
                        break;
                    }
                }

                if (isPartition) {
                    result.add(high - low + 1);
                    low = high + 1;
                    set.clear();
                }
            }

            set.add(c);
            high++;
        }

        return result;
    }
}