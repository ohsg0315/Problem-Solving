import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();

        Arrays.sort(candidates);
        backtrack(candidates, new LinkedList<>(), target, 0);

        return result;
    }

    private void backtrack(int[] candidates, LinkedList<Integer> comb, int remain, int idx) {
        if (remain == 0) {
            result.add(new ArrayList<>(comb));
            return;
        }

        for (int cur = idx; cur < candidates.length; ++cur) {
            if (cur > idx && candidates[cur] == candidates[cur - 1])
                continue;

            int num = candidates[cur];

            if (remain < num)
                break;

            comb.addLast(num);
            backtrack(candidates, comb, remain - num, cur + 1);
            comb.removeLast();
        }
    }
}