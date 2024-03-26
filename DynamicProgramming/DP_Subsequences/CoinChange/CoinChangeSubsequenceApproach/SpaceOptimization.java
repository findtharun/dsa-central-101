package DynamicProgramming.DP_Subsequences.CoinChange.CoinChangeSubsequenceApproach;

public class SpaceOptimization {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        // dp[ind][target] represent how many coins of type coins[ind] you can use for target
        int[] prev = new int[amount + 1];
        int[] curr = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0)
                prev[i] = i / coins[0];
            else
                prev[i] = (int) 1e9;
        }
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= amount; target++) {
                int notTake = prev[target];
                int take = (int) 1e9;
                if (coins[ind] <= target)
                    // We can Take Multiple Coins of Same Type, So Same index is Taken
                    take = 1 + curr[target - coins[ind]]; 
                curr[target] = Math.min(take, notTake); // // Since we Take the Same Index we take curr instead of Prev
            }
            prev = curr.clone();
        }
        return prev[amount] >= (int) 1e9 ? -1 : prev[amount];
    }
}
