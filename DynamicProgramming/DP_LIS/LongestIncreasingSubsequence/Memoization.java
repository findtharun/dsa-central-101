package DynamicProgramming.DP_LIS.LongestIncreasingSubsequence;

import java.util.*;

public class Memoization {
    public int helper(int currInd, int prevInd, int[] nums, int[][] dp) {
        if (currInd == nums.length)
            return 0;
        if (dp[currInd][prevInd + 1] != -1)
            return dp[currInd][prevInd + 1];
        int notTake = helper(currInd + 1, prevInd, nums, dp);
        int take = 0;
        if (prevInd == -1 || nums[currInd] > nums[prevInd])
            take = 1 + helper(currInd + 1, currInd, nums, dp);
        return dp[currInd][prevInd + 1] = Math.max(take, notTake);
    }

    public int lengthOfLIS(int[] nums) {
        int currInd = 0;
        int prevInd = -1;
        int n = nums.length;
        // dp[i][j] indicates length of LIS from i if Prev Ind is j-1
        int[][] dp = new int[n][n + 1]; // Since To Store -1, We are increasing all Indices by 1
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return helper(currInd, prevInd, nums, dp);
    }
}
