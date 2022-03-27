import java.util.PriorityQueue;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] result = new int[k];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        for (int row = 0, length = mat.length; row < length; row++) {
            int soldiers = 0;

            for (int type : mat[row]) {
                if (type == 0) {
                    break;
                }
                soldiers++;
            }
            priorityQueue.add(new int[]{row, soldiers});
        }

        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll()[0];
        }
        return result;
    }
}