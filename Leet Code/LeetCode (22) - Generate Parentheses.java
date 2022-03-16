import java.util.*;

class Solution {
    private List<String> result;

    private void permutation(StringBuilder sb, int left, int right, int length) {
        if (sb.length() == length * 2) {
            result.add(sb.toString());
            return;
        }

        if (left < length) {
            sb.append('(');
            permutation(sb, left + 1, right, length);
            sb.deleteCharAt(left + right);
        }

        if(right < left){
            sb.append(')');
            permutation(sb, left, right + 1, length);
            sb.deleteCharAt(left + right);
        }

    }

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();

        permutation(new StringBuilder(), 0, 0, n);

        return result;
    }
}