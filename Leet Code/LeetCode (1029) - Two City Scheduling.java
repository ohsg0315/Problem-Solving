import java.util.Arrays;

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int result = 0;
        Arrays.sort(costs, (o1, o2) -> (o1[0] - o1[1]) - (o2[0] - o2[1]));

        for (int i = 0, length = costs.length / 2; i < length; i++) {
            result += costs[i][0];
            result += costs[i + length][1];
        }

        return result;
    }
}