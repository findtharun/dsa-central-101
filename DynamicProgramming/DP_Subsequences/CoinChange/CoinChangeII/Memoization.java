package DynamicProgramming.DP_Subsequences.CoinChange.CoinChangeII;

import java.util.Arrays;

public class Memoization {
    public int changeUtil(int ind, int amount, int[] coins, int n, int[][] dp) {
        if (ind == n) {
            /*
             * Because If it is divisble Then There is one way with that
             * (Eg : Amount 6, Coins[n-1] --> 2,2,2)
             */
            if (amount == 0)
                return 1;
            else
                return 0;
        }
        if (dp[ind][amount] != -1)
            return dp[ind][amount];

        int notTake = changeUtil(ind + 1, amount, coins, n, dp); // Not Taking the Current
        int take = 0;
        if (coins[ind] <= amount)
            take = changeUtil(ind, amount - coins[ind], coins, n, dp); // Taking the Same coin
        return dp[ind][amount] = take + notTake;
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return changeUtil(0, amount, coins, n, dp);
    }
}
