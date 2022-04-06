import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Solution {

    private static final int MOD = 1_000_000_007;

    public int threeSumMulti(int[] arr, int target) {
        long result = 0;
        Map<Integer, Integer> treeMap = new TreeMap<>();

        for (int num : arr) {
            treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(treeMap.keySet());

        for (int idx = 0, size = list.size(); idx < size; idx++) {
            int low = idx, high = size - 1;

            if (treeMap.get(list.get(idx)) < 2) {
                low++;
            }

            while (low <= high) {
                int sum = list.get(idx) + list.get(low) + list.get(high);

                if (sum == target) {
                    if (idx == low && low == high) {
                        if (treeMap.get(list.get(idx)) < 3) {
                            break;
                        }
                        long cnt = treeMap.get(list.get(idx));
                        result += (cnt * (cnt - 1) * (cnt - 2) / 6);
                    }
                    else if (idx == low) {
                        long cnt = treeMap.get(list.get(idx));
                        result += (cnt * (cnt - 1) / 2 * treeMap.get(list.get(high)));
                    } else if (low == high) {
                        long cnt = treeMap.get(list.get(low));
                        result += (cnt * (cnt - 1) / 2 * treeMap.get(list.get(idx)));
                    } else {
                        result += ((long) treeMap.get(list.get(idx)) * treeMap.get(list.get(low)) * treeMap.get(list.get(high)));
                    }

                    result %= MOD;
                    low++;
                    high--;
                } else if (sum < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }

        return (int) result;
    }
}