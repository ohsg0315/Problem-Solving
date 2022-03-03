import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length < 3) {
            return result;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int number : nums) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        Set<String> used = new HashSet<>();

        for (int first : map.keySet()) {
            for (int second : map.keySet()) {
                int target = -(first + second);

                if (map.containsKey(target)) {
                    if ((first == second && map.get(first) < 2) || (first == target && map.get(first) < 2)
                            || (second == target && map.get(second) < 2) || (first == second && second == target && map.get(first) < 3)) {
                        continue;
                    }

                    String s = Arrays.asList(first, second, target)
                            .stream()
                            .sorted()
                            .collect(Collectors.toList())
                            .toString();

                    if (!used.contains(s)) {
                        used.add(s);
                        result.add(Arrays.asList(first, second, target));
                    }
                }
            }
        }
        return result;
    }
}