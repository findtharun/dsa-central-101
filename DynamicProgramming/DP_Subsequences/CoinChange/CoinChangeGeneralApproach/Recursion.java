package DynamicProgramming.DP_Subsequences.CoinChange.CoinChangeGeneralApproach;

public class Recursion {
    public int coinChange(int[] coins, int amount) {
        int ans = coinCount(coins, amount);
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }

    public int coinCount(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (amount < 0)
            return Integer.MAX_VALUE;
        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int ans = coinCount(coins, amount - coin);
            if (ans != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, 1 + ans);
            }
        }
        return minCoins;
    }
}
