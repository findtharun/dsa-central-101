package DynamicProgramming.DP_Subsequences.RodCutting;

import java.util.Arrays;

public class Memoization {
     // It is equivalent to Unbounded Knapsack - Weights are indices, Profits are Array Values
    public static int cutRodUtil(int ind, int[] price, int maxLen, int[][] dp) {
        // if ind is greater than or equal to maxLen or if maxLen is 0, indicating that
        // there are no more cuts to be made.
        if (ind >= maxLen || maxLen == 0) {
            return 0;
        }
        if (dp[ind][maxLen] != -1)
            return dp[ind][maxLen];
        int notTake = cutRodUtil(ind + 1, price, maxLen, dp);
        int take = Integer.MIN_VALUE;
        int rodLength = ind + 1;
        if (rodLength <= maxLen)
            take = price[ind] + cutRodUtil(ind, price, maxLen - rodLength, dp);
        return dp[ind][maxLen] = Math.max(take, notTake);
    }

    public static int cutRod(int price[], int n) {
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return cutRodUtil(0, price, n, dp);
    }
}
