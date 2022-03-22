import java.util.*;

class FreqStack {
    private int maxFreq;
    private List<Integer> stack;
    private Map<Integer, Integer> map;
    private Map<Integer, Integer> freq;

    public FreqStack() {
        stack = new LinkedList<>();
        map = new HashMap<>();
        freq = new HashMap<>();
    }

    public void push(int val) {
        stack.add(val);
        int f = map.getOrDefault(val, 0) + 1;
        map.put(val, f);
        freq.put(f, freq.getOrDefault(f, 0) + 1);
        maxFreq = Math.max(maxFreq, f);
    }

    public int pop() {
        ListIterator<Integer> iterator = stack.listIterator(stack.size());

        int val = -1;
        while (iterator.hasPrevious()) {
            val = iterator.previous();

            if (map.get(val) == maxFreq) {
                map.put(val, maxFreq - 1);
                int f = freq.get(maxFreq) - 1;

                if (f == 0) {
                    freq.remove(maxFreq);
                    maxFreq = 0;
                    for (int ff : freq.keySet()) {
                        maxFreq = Math.max(maxFreq, ff);
                    }
                } else {
                    freq.put(maxFreq, f);
                }

                stack.remove(iterator.previousIndex() + 1);
                break;
            }
        }

        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */