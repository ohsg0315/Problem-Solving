import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> treeMap = new TreeMap<>();

        for (int number : nums) {
            treeMap.put(number, treeMap.getOrDefault(number, 0) + number);
        }

        if (treeMap.size() == 1) {
            return treeMap.get(nums[0]);
        }

        Iterator<Integer> iterator = treeMap.keySet().iterator();
        int beforeKey = iterator.next(), beforeValue = treeMap.get(beforeKey);
        int curKey = iterator.next(), curValue = (curKey - beforeKey) == 1 ? Math.max(beforeValue, treeMap.get(curKey)) : beforeValue + treeMap.get(curKey);
        while (iterator.hasNext()) {
            int nextKey = iterator.next(), nextValue = treeMap.get(nextKey);

            if (nextKey - curKey == 1) {
                nextValue = Math.max(beforeValue + nextValue, curValue);
            } else {
                nextValue += curValue;
            }

            beforeValue = curValue;

            curKey = nextKey;
            curValue = nextValue;
        }

        return curValue;
    }
}