class Solution {
    private static final int MOD = 1_000_000_007;

    public int countOrders(int n) {
        long result = 1;

        n *= 2;

        do {
            result = result * n * (n - 1) / 2L;
            result %= MOD;
            n -= 2;
        }
        while (n > 0);

        return (int) result;
    }
}