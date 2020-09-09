import java.util.*;
import java.io.*;

public class Solution {
    public String[] solution(String[] record) {
        int cnt = 0;
        String[] answer = {};
        StringBuilder sb = new StringBuilder();
        HashMap<String, String> hm = new HashMap<>();

        for (String s : record) {
            String[] buf = s.split(" ");

            if (buf[0].equals("Enter")) {
                hm.put(buf[1], buf[2]);
                cnt++;
            } else if (buf[0].equals("Change")) {
                hm.put(buf[1], buf[2]);
            } else {
                cnt++;
            }
        }
        answer = new String[cnt];
        cnt = 0;
        for (String s : record) {
            String[] buf = s.split(" ");

            if (buf[0].equals("Enter")) {
                answer[cnt++] = hm.get(buf[1]) + "님이 들어왔습니다.";
            } else if (buf[0].equals("Leave")) {
                answer[cnt++] = hm.get(buf[1]) + "님이 나갔습니다.";
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
    } // end of main
} // end of class