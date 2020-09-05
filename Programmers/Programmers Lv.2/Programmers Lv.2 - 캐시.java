import java.util.*;
import java.io.*;

public class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> cache = new ArrayList<>();
        for (String city : cities) {
            String s = city.toUpperCase();
            if (cache.contains(s)) {
                // cache hit
                answer += 1;
                if (cache.size() == cacheSize) {
                    int idx = cache.indexOf(s);
                    cache.add(cache.remove(idx));
                } else {
                    cache.add(s);
                }
            }
            // 캐시에 없다면
            else {
                // cache miss
                answer += 5;
                // 캐시가 다 차있다면 하나 뺀다
                if (cache.size() == cacheSize && cache.size() != 0) {
                    cache.remove(0);
                }
                if (cacheSize != 0) {
                    cache.add(s);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        System.out.println(s.solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
    } // end of main
} // end of class