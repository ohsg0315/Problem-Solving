import java.util.PriorityQueue;

class KthLargest {
    private int k;
    private PriorityQueue<Integer> queue;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>();

        for (int num : nums) {
            queue.add(num);
        }

        while (queue.size() > k) {
            queue.poll();
        }
    }

    public int add(int val) {
        queue.add(val);

        if (queue.size() > k) {
            queue.poll();
        }

        return queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */