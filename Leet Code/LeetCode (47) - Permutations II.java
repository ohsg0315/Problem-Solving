import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    private Set<List<Integer>> set;
    private boolean[] pick;

    private void permutation(int[] nums, int cnt, List<Integer> list) {
        if (nums.length == cnt) {
            set.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!pick[i]) {
                pick[i] = true;
                list.add(nums[i]);

                permutation(nums, cnt + 1, list);

                pick[i] = false;
                list.remove(cnt);
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        set = new HashSet<>();
        pick = new boolean[nums.length];

        permutation(nums, 0, new ArrayList<>());

        return new ArrayList<>(set);
    }
}