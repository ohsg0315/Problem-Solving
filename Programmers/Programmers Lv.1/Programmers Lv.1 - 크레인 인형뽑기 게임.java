import java.io.*;
import java.util.*;

class Solution {
    private Stack<Integer>[] st;

    public int solution(int[][] board, int[] moves) {
        int n = board.length;
        int answer = 0;

        st = new Stack[n];
        Stack<Integer> res = new Stack<>();

        for (int i = 0; i < n; i++) {
            st[i] = new Stack<>();

            for (int j = n - 1; j >= 0; j--) {
                if (board[j][i] == 0) continue;
                st[i].push(board[j][i]);
            }
        }

        for (int i : moves) {
            if (st[i - 1].isEmpty()) continue;

            int cur = st[i - 1].pop();

            if (res.isEmpty()) res.push(cur);
            else {
                if (res.peek() == cur) {
                    System.out.println(cur);
                    res.pop();
                    answer += 2;
                } else res.push(cur);
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
    } // end of main
} // end of class
