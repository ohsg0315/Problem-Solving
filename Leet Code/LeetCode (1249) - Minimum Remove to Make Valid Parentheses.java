import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    private class Character {
        char c;
        int index;

        public Character(char c, int index) {
            this.c = c;
            this.index = index;
        }
    }

    public String minRemoveToMakeValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0, length = s.length(); i < length; i++) {
            char c = s.charAt(i);

            if (c == '(' || c == ')') {
                if (deque.isEmpty()) {
                    deque.push(new Character(c, i));
                } else {
                    if (deque.getLast().c == '(' && c == ')') {
                        deque.pollLast();
                    } else {
                        deque.addLast(new Character(c, i));
                    }
                }
            }
        }

        int index = -1;
        StringBuilder result = new StringBuilder();

        while (!deque.isEmpty()) {
            Character pop = deque.pollFirst();
            result.append(s, index + 1, pop.index);
            index = pop.index;
        }
        result.append(s, index + 1, s.length());

        return result.toString();
    }
}