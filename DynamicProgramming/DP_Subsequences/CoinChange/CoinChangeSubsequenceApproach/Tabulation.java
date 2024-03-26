package DynamicProgramming.DP_Subsequences.CoinChange.CoinChangeSubsequenceApproach;

public class Tabulation {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        // dp[ind][target] represent how many coins of type coins[ind] you can use for target
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0)
                dp[0][i] = i / coins[0];
            else
                dp[0][i] = (int) 1e9;
        }
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= amount; target++) {
                int notTake = dp[ind - 1][target];
                int take = (int) 1e9;
                if (coins[ind] <= target)
                    // We can Take Multiple Coins of Same Type, So Same index is Taken
                    take = 1 + dp[ind][target - coins[ind]]; 
                dp[ind][target] = Math.min(take, notTake);
            }
        }
        return dp[n - 1][amount] >= (int) 1e9 ? -1 : dp[n - 1][amount];
    }
}
