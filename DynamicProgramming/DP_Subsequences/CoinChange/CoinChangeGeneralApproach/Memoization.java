package DynamicProgramming.DP_Subsequences.CoinChange.CoinChangeGeneralApproach;

import java.util.Arrays;

public class Memoization {
    int[] dp;

    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        int ans = coinCount(coins, amount);
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }

    public int coinCount(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (amount < 0)
            return Integer.MAX_VALUE;

        if (dp[amount] != -1) {
            return dp[amount];
        }

        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int ans = coinCount(coins, amount - coin);
            if (ans != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, 1 + ans);
            }
        }
        dp[amount] = minCoins;
        return dp[amount];
    }
}
