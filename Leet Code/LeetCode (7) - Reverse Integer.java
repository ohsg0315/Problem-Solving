class Solution {
    public int reverse(int x) {
        boolean positive = x >= 0;
        long xx = x > 0 ? (long) x : (long) x * -1;

        StringBuilder result = new StringBuilder().append(0);
        while (xx != 0) {
            result.append(xx % 10);
            xx /= 10;
        }

        Long check = positive ? Long.parseLong(result.toString()) : -Long.parseLong(result.toString());

        if (check > Integer.MAX_VALUE || check < Integer.MIN_VALUE) {
            return 0;
        }

        return positive ? Integer.parseInt(result.toString()) : -Integer.parseInt(result.toString());
    }
}