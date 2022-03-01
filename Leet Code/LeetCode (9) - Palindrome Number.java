class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int high, low;
        int divider1 = (int) Math.pow(10, (int) Math.log10(x)), divider2 = 10;
        while (divider1 >= divider2) {
            high = x / divider1;
            low = x % divider2;

            if (high != low) {
                return false;
            }

            x %= divider1;
            x /= divider2;

            divider1 /= 100;
        }

        return true;
    }
}