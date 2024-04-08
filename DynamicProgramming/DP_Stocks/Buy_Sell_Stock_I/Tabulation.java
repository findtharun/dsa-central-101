package DynamicProgramming.DP_Stocks.Buy_Sell_Stock_I;

public class Tabulation {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1)
            return 0;
        int[] dp = new int[n + 1];
        // Dp Array Stores Min Value of Stock Till ith Day
        dp[0] = prices[0];
        int max_profit = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[i - 1], prices[i]);
            int curr_profit = prices[i] - dp[i];
            max_profit = Math.max(curr_profit, max_profit);
        }
        return max_profit;
    }
}
