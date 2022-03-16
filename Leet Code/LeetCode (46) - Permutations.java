import java.util.ArrayList;
import java.util.List;

class Solution {
    private boolean[] visited;
    private List<List<Integer>> result;

    private void permutation(List<Integer> list, int[] nums, int index) {
        if (index == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0, length = nums.length; i < length; i++) {
            if (!visited[i]) {
                list.add(nums[i]);
                visited[i] = true;

                permutation(list, nums, index + 1);
                list.remove(index);
                visited[i] = false;

            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        result = new ArrayList<>();

        permutation(new ArrayList<>(), nums, 0);
        return result;
    }
}