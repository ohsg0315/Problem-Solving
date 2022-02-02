import java.util.ArrayList;
import java.util.List;

class Solution {
    private int arrayLength = 'z' - 'a' + 1;

    private boolean isAnagram(int[] array) {
        for (int i = 0; i < arrayLength; i++) {
            if (array[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        int head = 0;
        List<Integer> result = new ArrayList<>();
        int[] array = new int[arrayLength];

        // 문자열 p가 s보다 길다면 return
        if (p.length() > s.length()) {
            return result;
        }

        // array에 문자열 p의 원소는 +1, s.substring의 원소는 -1
        for (int i = 0, pLength = p.length(); i < pLength; i++) {
            array[p.charAt(i) - 'a']++;
            array[s.charAt(i) - 'a']--;
        }

        // anagram인지 확인
        if (isAnagram(array)) {
            result.add(head);
        }

        // 한칸씩 이동하며, 이전에 빼준 head에 해당하는 원소값은 +1, 다음 해당하는 원소값은 -1
        for (int i = p.length(); i < s.length(); i++) {
            array[s.charAt(head) - 'a']++;
            head++;
            array[s.charAt(i) - 'a']--;

            // anagram인지 확인
            if (isAnagram(array)) {
                result.add(head);
            }
        }

        return result;
    }
}