import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final char[][] PRESET = {
            {}, {},
            {'a', 'b', 'c'}, {'d', 'e', 'f'},
            {'g', 'h', 'i'}, {'j', 'k', 'l'},
            {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };

    private List<String> result;

    private void permutation(String digits, int index, StringBuilder sb) {
        if (digits.length() == index) {
            if(sb.length() > 0) {
                result.add(sb.toString());
            }
            return;
        }

        int cur = digits.charAt(index) - '0';
        for (int i = 0; i < PRESET[cur].length; i++) {
            permutation(digits, index + 1, sb.append(PRESET[cur][i]));
            sb.setLength(index);
        }
    }

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();

        permutation(digits, 0, new StringBuilder());

        System.out.println(result);
        return result;
    }
}