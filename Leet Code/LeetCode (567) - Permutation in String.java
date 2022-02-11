class Solution {
    private static final int ALPHA_LENGTH = 'z' - 'a' + 1;

    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length(), s2Len = s2.length();

        if (s1Len > s2Len) return false;

        int[] s1Arr = new int[ALPHA_LENGTH], s2Arr = new int[ALPHA_LENGTH];

        for (int i = 0; i < s1Len; i++) {
            s1Arr[s1.charAt(i) - 'a']++;
            s2Arr[s2.charAt(i) - 'a']++;
        }

        boolean result = false;
        int head = 0, tail = s1Len;

        while (tail <= s2Len) {
            result = true;
            for (int i = 0; i < ALPHA_LENGTH; i++) {
                if (s1Arr[i] != s2Arr[i]) {
                    result = false;
                    break;
                }
            }

            if (result || tail == s2Len) {
                return result;
            }

            s2Arr[s2.charAt(head++) - 'a']--;
            s2Arr[s2.charAt(tail++) - 'a']++;
        }
        return result;
    }
}