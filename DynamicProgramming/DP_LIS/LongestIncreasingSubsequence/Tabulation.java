package DynamicProgramming.DP_LIS.LongestIncreasingSubsequence;

public class Tabulation {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // dp[i][j] indicates length of LIS from i if Prev Ind is j-1
        // Tabulation will have extra row
        // Since To Store -1, We are increasing all Indices by 1
        int[][] dp = new int[n + 1][n + 1];
        for (int currInd = n - 1; currInd >= 0; currInd--) {
            for (int prevInd = currInd - 1; prevInd >= -1; prevInd--) {
                int notTake = dp[currInd + 1][prevInd + 1]; // -1+1 = 0;
                int take = 0;
                if (prevInd == -1 || nums[currInd] > nums[prevInd])
                    take = 1 + dp[currInd + 1][currInd + 1]; // We always do +1 to accomodate -1 for prevInd
                dp[currInd][prevInd + 1] = Math.max(take, notTake);
            }
        }
        return dp[0][-1 + 1];
    }
}
