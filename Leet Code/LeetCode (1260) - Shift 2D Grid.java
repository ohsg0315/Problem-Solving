import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int[] row : grid) {
            for (int column : row) {
                deque.add(column);
            }
        }

        while (k-- > 0) {
            deque.addFirst(deque.pollLast());
        }

        for (int i = 0, row = grid.length; i < row; i++) {
            List<Integer> bufList = new ArrayList<>();
            for (int j = 0, column = grid[i].length; j < column; j++) {
                bufList.add(deque.pollFirst());
            }
            result.add(bufList);
        }

        return result;
    }
}