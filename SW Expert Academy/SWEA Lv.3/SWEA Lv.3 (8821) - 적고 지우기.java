import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            HashMap<Character, Integer> hm = new HashMap<>();
            String numbers = br.readLine();
            int len = numbers.length(), res = 0;

            for (int i = 0; i < len; i++) {
                if(hm.containsKey(numbers.charAt(i)) && hm.get(numbers.charAt(i)) == 1){
                    hm.put(numbers.charAt(i), 0);
                }else {
                    hm.put(numbers.charAt(i), 1);
                }
            }
            for(Map.Entry<Character, Integer> entry : hm.entrySet()){
                if(entry.getValue() == 1){
                    res++;
                }
            }
            System.out.println("#" + testCase + " " + res);
        }
    }
}