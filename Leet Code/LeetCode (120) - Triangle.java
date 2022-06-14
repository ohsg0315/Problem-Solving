import java.util.Arrays;
import java.util.List;

class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] cache = new int[triangle.size()][triangle.size() + 1];

        for (int i = 0; i < triangle.size(); i++) {
            Arrays.fill(cache[i], Integer.MAX_VALUE);
        }

        cache[0][0] = triangle.get(0).get(0);

        for (int depth = 1, maxDepth = triangle.size(); depth < maxDepth; depth++) {
            List<Integer> list = triangle.get(depth);

            //index = 0
            cache[depth][0] = cache[depth - 1][0] + list.get(0);

            //index: middle
            for (int idx = 1; idx < depth; idx++) {
                cache[depth][idx] = Math.min(cache[depth - 1][idx - 1], cache[depth - 1][idx]) + list.get(idx);
            }

            //index: depth
            cache[depth][depth] = cache[depth - 1][depth - 1] + list.get(depth);
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0, maxDepth = triangle.size(); i < maxDepth; i++) {
            result = Math.min(result, cache[maxDepth - 1][i]);
        }

        return result;
    }
}