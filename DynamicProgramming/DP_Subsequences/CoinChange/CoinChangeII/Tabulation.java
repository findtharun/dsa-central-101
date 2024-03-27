package DynamicProgramming.DP_Subsequences.CoinChange.CoinChangeII;

public class Tabulation {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int target = 0; target <= amount; target++) {
            // If any target is divisble then 1 Way can be made up
            if (target % coins[0] == 0)
                dp[0][target] = 1;
        }
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= amount; target++) {
                int notTake = dp[ind - 1][target];
                int take = 0;
                if (coins[ind] <= amount && target - coins[ind] >= 0) {
                    take = dp[ind][target - coins[ind]];
                }
                dp[ind][target] = take + notTake;
            }
        }
        return dp[n - 1][amount];
    }
}
