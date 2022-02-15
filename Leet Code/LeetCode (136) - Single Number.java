import java.util.HashSet;
import java.util.Set;

class Solution {
    //Using XOR
    public int singleNumber(int[] nums) {
        int result = 0;

        for (int number : nums) {
            result ^= number;
        }

        return result;
    }

    //Using Set
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int number : nums) {
            if (set.contains(number)) {
                set.remove(number);
            } else {
                set.add(number);
            }
        }

        return set.iterator().next();
    }
}