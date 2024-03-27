package DynamicProgramming.DP_Subsequences.CoinChange.CoinChangeSubsequenceApproach;

public class Recursion {
    public int coinChangeUtil(int ind, int[] coins, int amount) {
        if (ind == coins.length) {
            if (amount % coins[coins.length - 1] == 0)
                return amount / coins[coins.length - 1];
            else
                return (int) Math.pow(10, 9);
        }
        int notTake = coinChangeUtil(ind + 1, coins, amount);
        int take = (int) Math.pow(10, 9);
        if (coins[ind] <= amount)
            take = 1 + coinChangeUtil(ind, coins, amount - coins[ind]);
        return Math.min(take, notTake);
    }

    public int coinChange(int[] coins, int amount) {
        int ans = coinChangeUtil(0,coins,amount);
        return  ans == (int) Math.pow(10, 9) ? -1 : ans;
    }
}
