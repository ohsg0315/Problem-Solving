import java.util.*;
import java.io.*;

public class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer>pq = new PriorityQueue<>();

        for(int i : scoville){
            pq.offer(i);
        }
        while(pq.peek() < K){
            if(pq.size() == 1){
                return -1;
            }
            int first = pq.poll(), second = pq.poll();
            pq.offer(first + second * 2);
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {1,2,3,9,10,12}, 7));
    }
}