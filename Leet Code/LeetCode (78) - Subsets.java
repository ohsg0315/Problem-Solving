import java.util.ArrayList;
import java.util.List;

class Solution {
    private static int length, finish;
    private static boolean[] visited;
    private static List<List<Integer>> result;

    private static void combination(int[] nums, int index, int cnt, List<Integer> buffer) {
        if (cnt == finish) {
            result.add(new ArrayList<>(buffer));
            return;
        }

        for (int i = index; i < length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                buffer.add(nums[i]);

                combination(nums, i + 1, cnt + 1, buffer);

                visited[i] = false;
                buffer.remove(buffer.size() - 1);
            }
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        length = nums.length;
        visited = new boolean[length];
        result = new ArrayList<>();

        result.add(new ArrayList<>());
        for (int i = 0; i < length; i++) {
            finish = i + 1;
            combination(nums, 0,0, new ArrayList<>());
        }

        return result;
    }
}