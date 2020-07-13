import java.util.*;
import java.io.*;

public class Solution {
    class Documents {
        int weight, location;

        Documents(int weight, int location) {
            this.weight = weight;
            this.location = location;
        }
    }

    public int solution(int[] priorities, int location) {
        int answer = 0, len = priorities.length;
        Documents[] documents = new Documents[priorities.length];
        Queue<Documents> qu = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            documents[i] = new Documents(priorities[i], i);
            qu.offer(documents[i]);
        }
        Arrays.sort(priorities);

        while (!qu.isEmpty()) {
            Documents buf = qu.poll();

            if (buf.weight == priorities[len - 1]) {
                len--;
                answer++;

                if (buf.location == location) {
                    break;
                }
            } else {
                qu.offer(buf);
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        solution.solution(new int[]{2, 1, 3, 2}, 2);
    }
}