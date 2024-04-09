package DynamicProgramming.DP_Stocks.Buy_Sell_Stock_With_Fee;

import java.util.*;

public class Memoization {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n <= 1)
            return 0;

        int[][] dp = new int[n][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1); // Initialize with -1 to indicate uncalculated states
        }
        return calculateMaxProfit(prices, 0, 0, dp, fee);
    }

    public int calculateMaxProfit(int[] prices, int day, int holdingStock, int[][] dp, int fee) {
        // If we've reached the last day, we can't perform any transactions,
        // and the maximum profit achievable is 0.
        if (day >= prices.length)
            return 0;

        if (dp[day][holdingStock] != -1)
            return dp[day][holdingStock];

        if (holdingStock == 1) {
            int sellToday = prices[day] - fee + calculateMaxProfit(prices, day + 1, 0, dp, fee);
            int skipToday = calculateMaxProfit(prices, day + 1, 1, dp, fee);
            dp[day][holdingStock] = Math.max(sellToday, skipToday);
        } else {
            int buyToday = -prices[day] + calculateMaxProfit(prices, day + 1, 1, dp, fee);
            int skipToday = calculateMaxProfit(prices, day + 1, 0, dp, fee);
            dp[day][holdingStock] = Math.max(buyToday, skipToday);
        }

        return dp[day][holdingStock];
    }
}
