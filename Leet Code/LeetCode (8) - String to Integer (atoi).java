class Solution {
    public int myAtoi(String s) {
        //Step 1.
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }

        //Step 2.
        boolean isNegative = s.charAt(0) == '-';

        //Step 3.
        StringBuilder result = new StringBuilder().append(0);
        int index = isNegative || s.charAt(0) == '+' ? 1 : 0;
        for (int i = index, length = s.length(); i < length; i++) {
            char c = s.charAt(i);

            if (c < '0' || c > '9') {
                break;
            }

            result.append(c);
        }

        if (isNegative) {
            result.insert(0, '-');
        }

        try {
            return Integer.parseInt(result.toString());
        } catch (NumberFormatException e) {
            if (isNegative) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }
}