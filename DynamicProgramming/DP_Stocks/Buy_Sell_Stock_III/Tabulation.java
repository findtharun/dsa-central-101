package DynamicProgramming.DP_Stocks.Buy_Sell_Stock_III;

public class Tabulation {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1)
            return 0;
        // At Most 2 transactions(0,1,2)
        int[][][] dp = new int[n + 1][2][2 + 1];
        int profit = 0;
        for (int day = n - 1; day >= 0; day--) {
            for (int holdingStock = 0; holdingStock <= 1; holdingStock++) {
                for (int cap = 1; cap <= 2; cap++) {
                    if (holdingStock == 1) {
                        int sellToday = prices[day] + dp[day + 1][0][cap - 1];
                        int skipToday = dp[day + 1][1][cap];
                        profit = Math.max(sellToday, skipToday);
                    }
                    if (holdingStock == 0) {
                        int buyToday = -prices[day] + dp[day + 1][1][cap];
                        int skipToday = dp[day + 1][0][cap];
                        profit = Math.max(buyToday, skipToday);
                    }
                    dp[day][holdingStock][cap] = profit;
                }
            }
        }
        return dp[0][0][2];
    }
}
