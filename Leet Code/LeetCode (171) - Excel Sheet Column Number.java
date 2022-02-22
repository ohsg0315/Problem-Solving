class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0, length = columnTitle.length(); i < length; i++) {
            result += (columnTitle.charAt(i) - 'A' + 1) * (int) Math.pow(26, length - i - 1);
        }
        return result;
    }
}