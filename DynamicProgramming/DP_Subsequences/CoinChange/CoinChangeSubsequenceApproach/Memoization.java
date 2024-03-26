package DynamicProgramming.DP_Subsequences.CoinChange.CoinChangeSubsequenceApproach;

import java.util.Arrays;

public class Memoization {
    public int coinChangeUtil(int ind, int[] coins, int amount, int[][] dp) {
        if (ind == coins.length) {
            if (amount % coins[coins.length - 1] == 0)
                return amount / coins[coins.length - 1];
            else
                return (int) Math.pow(10, 9);
        }
        if (dp[ind][amount] != -1)
            return dp[ind][amount];
        int notTake = coinChangeUtil(ind + 1, coins, amount, dp);
        int take = (int) Math.pow(10, 9);
        ;
        if (coins[ind] <= amount)
            take = 1 + coinChangeUtil(ind, coins, amount - coins[ind], dp);
        return dp[ind][amount] = Math.min(take, notTake);
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        int ans = coinChangeUtil(0, coins, amount, dp);
        return ans == (int) Math.pow(10, 9) ? -1 : ans;
    }
}
