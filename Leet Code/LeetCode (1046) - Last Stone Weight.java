import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int stone : stones) {
            priorityQueue.add(stone);
        }

        while (priorityQueue.size() > 1) {
            int y = priorityQueue.poll(), x = priorityQueue.poll();

            if (y > x) {
                priorityQueue.add(y - x);
            }
        }

        return priorityQueue.isEmpty() ? 0 : priorityQueue.poll();
    }
}