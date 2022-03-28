import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedStr = String.valueOf(chars);

            map.putIfAbsent(sortedStr, new ArrayList<>());
            map.get(sortedStr).add(s);
        }

        List<List<String>> result = new ArrayList<>();
        result.addAll(map.values());

        return result;
    }
}