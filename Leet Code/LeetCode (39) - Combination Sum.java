import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private List<List<Integer>> result;

    private void repeatCombination(int[] candidates, int target, int total, int index, List<Integer> list) {
        for (int i = index; i < candidates.length; i++) {
            int next = total + candidates[i];

            if (next > target) {
                return;
            } else if (next == target) {
                list.add(candidates[i]);
                result.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                return;
            } else {
                list.add(candidates[i]);
                repeatCombination(candidates, target, total + candidates[i], i, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();

        Arrays.sort(candidates);
        repeatCombination(candidates, target, 0, 0, new ArrayList<>());

        return result;
    }
}