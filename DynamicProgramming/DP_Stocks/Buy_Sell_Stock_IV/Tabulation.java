package DynamicProgramming.DP_Stocks.Buy_Sell_Stock_IV;

public class Tabulation {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][k + 1];
        for (int day = n - 1; day >= 0; day--) {
            for (int holdingStock = 0; holdingStock <= 1; holdingStock++) {
                for (int cap = 1; cap <= k; cap++) {
                    if (holdingStock == 1) {
                        int sellToday = prices[day] + dp[day + 1][0][cap - 1];
                        int skipToday = 0 + dp[day + 1][1][cap];
                        dp[day][holdingStock][cap] = Math.max(sellToday, skipToday);
                    }
                    if (holdingStock == 0) {
                        int buyToday = -prices[day] + dp[day + 1][1][cap];
                        int skipToday = 0 + dp[day + 1][0][cap];
                        dp[day][holdingStock][cap] = Math.max(buyToday, skipToday);
                    }
                }
            }

        }
        return dp[0][0][k];
    }
}
