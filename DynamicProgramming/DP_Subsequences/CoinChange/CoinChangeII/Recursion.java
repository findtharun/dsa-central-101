package DynamicProgramming.DP_Subsequences.CoinChange.CoinChangeII;

public class Recursion {
    public int changeUtil(int ind, int amount, int[] coins) {
        if (ind == coins.length) {
            /*
             * Because If it is divisble Then There is one way with that
             * (Eg : Amount 6, Coins[n-1] --> 2,2,2)
             */
            if (amount == 0)
                return 1;
            else
                return 0;
        }

        int notTake = changeUtil(ind + 1, amount, coins); // Not Taking the Current
        int take = 0;
        if (coins[ind] <= amount)
            take = changeUtil(ind, amount - coins[ind], coins); // Taking the Same coin
        return take + notTake;
    }

    public int change(int amount, int[] coins) {
        return changeUtil(0, amount, coins);
    }
}
