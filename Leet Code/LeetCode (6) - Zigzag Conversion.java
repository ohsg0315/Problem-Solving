class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder result = new StringBuilder();
        int cycle = numRows * 2 - 2, length = s.length();

        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < length; j += cycle) {
                result.append(s.charAt(j));

                if (i != 0 && i != numRows - 1 && j + cycle - (i * 2) < length) {
                    result.append(s.charAt(j + cycle - (i * 2)));
                }
            }
        }

        return result.toString();
    }
}