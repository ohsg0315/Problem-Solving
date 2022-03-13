class Solution {
    private int[] getPi(String pattern) {
        int prefix = 0;
        int[] pi = new int[pattern.length()];

        for (int suffix = 1, pLength = pattern.length(); suffix < pLength; suffix++) {
            while (prefix > 0 && pattern.charAt(suffix) != pattern.charAt(prefix)) {
                prefix = pi[prefix - 1];
            }

            if (pattern.charAt(suffix) == pattern.charAt(prefix)) {
                pi[suffix] = ++prefix;
            }
        }
        return pi;
    }

    private int KMP(String origin, String pattern, int[] pi) {
        int j = 0;
        for (int i = 0, oLength = origin.length(); i < oLength; i++) {
            while (j > 0 && origin.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }

            if (origin.charAt(i) == pattern.charAt(j)) {
                if (j == pattern.length() - 1) {
                    return i - pattern.length() + 1;
                } else {
                    j++;
                }
            }
        }
        return -1;
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        int[] pi = getPi(needle);

        return KMP(haystack, needle, pi);
    }
}