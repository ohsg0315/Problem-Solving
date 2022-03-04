class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();

        int minLength = Integer.MAX_VALUE, index = -1;
        for (int i = 0, size = strs.length; i < size; i++) {
            if (strs[i].length() < minLength) {
                minLength = strs[i].length();
                index = i;
            }
        }

        for (int i = 0; i < minLength; i++) {
            result.append(strs[index].charAt(i));
        }

        int size = strs.length;
        boolean isPrefix = true;
        while (result.length() > 0) {
            for (int i = 0; i < size; i++) {
                if (!strs[i].startsWith(result.toString())) {
                    isPrefix = false;
                    break;
                }
            }

            if (isPrefix) {
                return result.toString();
            }

            isPrefix = true;
            result.setLength(--minLength);
        }

        return result.toString();
    }
}