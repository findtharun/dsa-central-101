package DynamicProgramming.DP_Subsequences.RodCutting;

public class Tabulation {
    public static int cutRod(int price[], int n) {
        int[][] dp = new int[n][n + 1];
        // dp[i][j] represents the maximum obtainable price for a rod of length i and maximum length j.
        for (int maxLen = 1; maxLen <= n; maxLen++) {
            dp[0][maxLen] = price[0] * (maxLen / (1));
        }
        for (int ind = 1; ind < n; ind++) {
            for (int maxLen = 0; maxLen <= n; maxLen++) {
                int notTake = dp[ind - 1][maxLen];
                int take = Integer.MIN_VALUE;
                int rodLen = ind + 1;
                if (rodLen <= maxLen)
                    take = price[ind] + dp[ind][maxLen - rodLen];
                dp[ind][maxLen] = Math.max(take, notTake);
            }
        }
        return dp[n - 1][n];
    }
}
