import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }


        List<Map.Entry<Integer, Integer>> collect = new ArrayList<>(map.entrySet());
        Collections.sort(collect, Map.Entry.comparingByValue());

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = collect.get(collect.size() - 1 - i).getKey();
        }

        return result;
    }
}