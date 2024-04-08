package DynamicProgramming.DP_Stocks.Buy_Sell_Stock_III;

import java.util.*;

public class Memoization {
    public int calculateMaxProfit(int day, int holdingStock, int[] prices, int[][][] dp, int cap) {
        if (day >= prices.length)
            return 0;// If we've reached the last day, we can't perform any transactions,
        // and the maximum profit achievable is 0.
        if (cap == 0)
            return 0;
        if (dp[day][holdingStock][cap] != -1)
            return dp[day][holdingStock][cap];
        if (holdingStock == 1) {
            int sellToday = prices[day] + calculateMaxProfit(day + 1, 0, prices, dp, cap - 1);
            int skipToday = 0 + calculateMaxProfit(day + 1, 1, prices, dp, cap);
            dp[day][holdingStock][cap] = Math.max(sellToday, skipToday);
        }
        if (holdingStock == 0) {
            int buyToday = -prices[day] + calculateMaxProfit(day + 1, 1, prices, dp, cap);
            int skipToday = 0 + calculateMaxProfit(day + 1, 0, prices, dp, cap);
            dp[day][holdingStock][cap] = Math.max(buyToday, skipToday);
        }
        return dp[day][holdingStock][cap];
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int cap = 2; // At Most 2 transactions(0,1,2)
        int[][][] dp = new int[n][2][cap + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return calculateMaxProfit(0, 0, prices, dp, 2);
    }
}
