class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, stock = prices[0];

        for (int i = 1, day = prices.length; i < day; i++) {
            int price = prices[i];
            if (stock > price) {
                stock = price;
            } else {
                profit = Math.max(profit, price - stock);
            }
        }

        return profit;
    }
}