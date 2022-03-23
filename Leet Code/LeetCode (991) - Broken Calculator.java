import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int brokenCalc(int startValue, int target) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] {target, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == startValue) {
                return now[1];
            }

            else if (now[0] < startValue) {
                return startValue - now[0] + now[1];
            }

            if (now[0] % 2 == 0) {
                queue.add(new int[]{now[0] / 2, now[1] + 1});
            } else {
                queue.add(new int[]{now[0] + 1, now[1] + 1});
            }

        }

        return -1;
    }
}