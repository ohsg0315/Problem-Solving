import java.util.*;
import java.io.*;

public class Solution {
    public int solution(String s) {
        int answer = s.length();
        StringBuilder sb = new StringBuilder();
        for (int size = 1, maxSize = s.length() / 2; size <= maxSize; size++) {
            int cnt = 1;
            sb.setLength(0);
            String buf = s.substring(0, size);

            for (int i = size, length = s.length(); i < length; i += size) {
                if (i + size > length) {
                    if (cnt == 1) {
                        sb.append(buf);
                    } else {
                        sb.append(cnt).append(buf);
                    }
                    cnt = 1;
                    buf = s.substring(i, length);
                    break;
                } else if (buf.equals(s.substring(i, i + size))) {
                    cnt++;
                } else {
                    if (cnt == 1) sb.append(buf);
                    else sb.append(cnt).append(buf);

                    cnt = 1;
                    buf = s.substring(i, i + size);
                }
            }
            if (cnt == 1) sb.append(buf);
            else sb.append(cnt).append(buf);

            answer = Math.min(answer, sb.toString().length());
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        System.out.println(s.solution("ababcdcdababcdcd"));

    } // end of main
} // end of class