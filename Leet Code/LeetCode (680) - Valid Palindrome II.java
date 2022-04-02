class Solution {
    private boolean isPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        int low = 0, high = s.length() - 1;

        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return isPalindrome(s.substring(low + 1, high + 1)) | isPalindrome(s.substring(low, high));
            }

            low++;
            high--;
        }

        return true;
    }
}