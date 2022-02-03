import java.util.HashMap;
import java.util.Map;

class Solution {
    /* 방법1 */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int result = 0, n = nums1.length;
        Map<Integer, Integer> sMap1 = new HashMap<>(), sMap2 = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum1 = nums1[i] + nums2[j];
                int sum2 = nums3[i] + nums4[j];

                sMap1.put(sum1, sMap1.getOrDefault(sum1, 0) + 1);
                sMap2.put(sum2, sMap2.getOrDefault(sum2, 0) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry1 : sMap1.entrySet()) {
            for (Map.Entry<Integer, Integer> entry2 : sMap2.entrySet()) {
                if (entry1.getKey() + entry2.getKey() == 0) {
                    result += entry1.getValue() * entry2.getValue();
                }
            }
        }

        return result;
    }

    /* 방법2 */
    public int fourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int result = 0, n = nums1.length;
        Map<Integer, Integer> sMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = nums1[i] + nums2[j];

                sMap.put(sum, sMap.getOrDefault(sum, 0) + 1);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = nums3[i] + nums4[j];

                result += sMap.getOrDefault(-sum, 0);
            }
        }

        return result;
    }
}