package DynamicProgramming.DP_Subsequences.CoinChange.CoinChangeII;

public class SpaceOptimization {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] prev = new int[amount + 1];
        int[] curr = new int[amount + 1];
        for (int target = 0; target <= amount; target++) {
            // If any target is divisble then 1 Way can be made up
            if (target % coins[0] == 0)
                prev[target] = 1;
        }
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= amount; target++) {
                int notTake = prev[target];
                int take = 0;
                // We can Take Multiple Coins of Same Type, So Same index is Taken
                if (coins[ind] <= amount && target - coins[ind] >= 0) {
                    take = curr[target - coins[ind]]; // Since we Take the Same Index we take curr instead of Prev
                }
                curr[target] = take + notTake;
            }
            prev = curr.clone();
        }
        return prev[amount];
    }
}
