package DynamicProgramming.DP_Subsequences.HasSubsetSumEqualToK.CountSubsetsWithSumK;

public class Tabulation {
    public static int findWays(int num[], int tar) {
        int n = num.length;
        int[][] dp = new int[n][tar + 1];

        for (int ind = 0; ind < n; ind++)
            dp[ind][0] = 1; // Empty Subset is a way to reach target sum 0
        if (num[0] == 0)
            dp[0][0] = 2; //Because Take = 0 , Not Take (Total 2)
        if (num[0] <= tar && num[0] != 0)
            dp[0][num[0]] = 1;

        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= tar; target++) {
                int notTake = dp[ind - 1][target];
                int take = 0;
                if (num[ind] <= target) {
                    take = dp[ind - 1][target - num[ind]];
                }
                dp[ind][target] = (take + notTake) % ((int) (1e9) + 7);
            }
        }
        return dp[n - 1][tar];
    }
}
