package DynamicProgramming.DP_Stocks.Buy_Sell_Stock_II;

import java.util.*;

public class Memoization {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1)
            return 0;
        
        int[][] dp = new int[n][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1); // Initialize with -1 to indicate uncalculated states
        }
        return calculateMaxProfit(prices, 0, 0, dp);
    }

    public int calculateMaxProfit(int[] prices, int day, int holdingStock, int[][] dp) {
        // If we've reached the last day, we can't perform any transactions,
        // and the maximum profit achievable is 0.
        if (day >= prices.length)
            return 0;

        if (dp[day][holdingStock] != -1)
            return dp[day][holdingStock];

        if (holdingStock == 1) {
            int sellToday = prices[day] + calculateMaxProfit(prices, day + 1, 0, dp);
            int skipToday = calculateMaxProfit(prices, day + 1, 1, dp);
            dp[day][holdingStock] = Math.max(sellToday, skipToday);
        } else {
            int buyToday = -prices[day] + calculateMaxProfit(prices, day + 1, 1, dp);
            int skipToday = calculateMaxProfit(prices, day + 1, 0, dp);
            dp[day][holdingStock] = Math.max(buyToday, skipToday);
        }
        
        return dp[day][holdingStock];
    }
}
