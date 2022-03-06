class Solution {
    public int maxProfit(int[] prices) {
        int result = 0, buy = prices[0], cur = prices[0];

        for (int i = 1, length = prices.length; i < length; i++) {
            int price = prices[i];

            if (cur > price) {
                result += cur - buy;

                cur = price;
                buy = price;
            } else {
                cur = price;
            }
        }

        return result + cur - buy;
    }
}