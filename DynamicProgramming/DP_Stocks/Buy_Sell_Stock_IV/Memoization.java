package DynamicProgramming.DP_Stocks.Buy_Sell_Stock_IV;

import java.util.*;

public class Memoization {
    public int calculateMaxProfit(int day, int holdingStock, int k, int[] prices, int[][][] dp) {
        if (day >= prices.length)
            return 0;
        if (k == 0)
            return 0;
        if (dp[day][holdingStock][k] != -1)
            return dp[day][holdingStock][k];
        if (holdingStock == 1) {
            int sellToday = prices[day] + calculateMaxProfit(day + 1, 0, k - 1, prices, dp);
            int skipToday = 0 + calculateMaxProfit(day + 1, 1, k, prices, dp);
            dp[day][holdingStock][k] = Math.max(sellToday, skipToday);
        }
        if (holdingStock == 0) {
            int buyToday = -prices[day] + calculateMaxProfit(day + 1, 1, k, prices, dp);
            int skipToday = 0 + calculateMaxProfit(day + 1, 0, k, prices, dp);
            dp[day][holdingStock][k] = Math.max(buyToday, skipToday);
        }
        return dp[day][holdingStock][k];
    }

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return calculateMaxProfit(0, 0, k, prices, dp);
    }
}
