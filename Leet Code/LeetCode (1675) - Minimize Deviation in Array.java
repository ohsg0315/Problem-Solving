import java.util.TreeSet;

class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int number : nums) {
            treeSet.add(number % 2 == 0 ? number : number * 2);
        }

        int result = treeSet.last() - treeSet.first();
        while (treeSet.last() % 2 == 0) {
            treeSet.add(treeSet.last() / 2);
            treeSet.remove(treeSet.last());

            result = Math.min(result, treeSet.last() - treeSet.first());
        }

        return result;
    }
}