class Solution {
    public int divide(int dividend, int divisor) {
        boolean isNegative = dividend < 0 ^ divisor < 0;
        int result = 0;


        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        } else if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            } else if (divisor == -1) {
                return Integer.MAX_VALUE;
            }

            dividend = divisor > 0 ? dividend + divisor : dividend - divisor;
            result++;
        }

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        while (dividend >= divisor) {
            dividend -= divisor;
            result++;
        }

        return isNegative ? -result : result;
    }
}