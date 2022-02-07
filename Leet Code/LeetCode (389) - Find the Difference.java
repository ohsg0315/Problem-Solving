class Solution {
    public char findTheDifference(String s, String t) {
        char result = 0;

        for (int i = 0, sLength = s.length(); i < sLength; i++) {
            result -= s.charAt(i);
            result += t.charAt(i);
        }

        result += t.charAt(t.length() - 1);

        return result;
    }
}