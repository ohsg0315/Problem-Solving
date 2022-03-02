class Solution {
    public boolean isSubsequence(String s, String t) {
        int index = 0, sLen = s.length();

        for (int i = 0, tLen = t.length(); i < tLen; i++) {
            if (index == sLen) {
                return true;
            }

            if (t.charAt(i) == s.charAt(index)) {
                index++;
            }
        }

        return index == sLen;
    }
}