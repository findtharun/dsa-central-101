package DynamicProgramming.DP_Subsequences.HasSubsetSumEqualToK.CountSubsetsWithSumK;

// https://www.codingninjas.com/studio/problems/count-subsets-with-sum-k_3952532

import java.util.Arrays;

public class Memoization {
    public static int subsetsWithSumK(int ind, int[] num, int k, int[][] dp) {
        if (ind == num.length) {
            if (k == 0 && num[num.length - 1] == 0)
                return 2;
            if (k == 0 || num[num.length - 1] == 0)
                return 1;
            return 0;
        }
        if (dp[ind][k] != -1)
            return dp[ind][k];

        int notTake = subsetsWithSumK(ind + 1, num, k, dp);

        int take = 0;
        if (num[ind] <= k)
            take = subsetsWithSumK(ind + 1, num, k - num[ind], dp);
        return dp[ind][k] = (take + notTake) % ((int) (1e9) + 7);
    }

    public static int findWays(int num[], int tar) {
        // Write your code here.
        int n = num.length;
        int[][] dp = new int[n][tar + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return subsetsWithSumK(0, num, tar, dp);
    }
}
