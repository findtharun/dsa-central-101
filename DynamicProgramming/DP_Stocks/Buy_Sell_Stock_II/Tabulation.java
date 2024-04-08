package DynamicProgramming.DP_Stocks.Buy_Sell_Stock_II;

public class Tabulation {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1)
            return 0;

        // Create a 2D array to store the maximum profit at each day and holding status
        // 0 -> not holding, 1 -> holding
        int[][] dp = new int[n][2];

        dp[0][0] = 0; // If We don't hold any stock on the first day
        dp[0][1] = -prices[0]; // We hold the stock on the first day with the cost of prices[0]. 
                               // Profit is Negative cause we did not sell

        // Calculate the maximum profit for each day
        for (int i = 1; i < n; i++) {
            // If we don't hold the stock at the end of day i, we can either:
            // 1. Not buy anything and keep the same state (dp[i - 1][0]), or
            // 2. Sell the stock we bought before (dp[i - 1][1] + prices[i])
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);

            // If we hold the stock at the end of day i, we can either:
            // 1. Not sell anything and keep the same state (dp[i - 1][1]), or
            // 2. Buy a stock today (dp[i - 1][0] - prices[i])
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        // The maximum profit is the profit we have when not holding any stock at the last day
        return dp[n - 1][0];
    }
}
