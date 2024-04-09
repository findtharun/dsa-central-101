package DynamicProgramming.DP_LIS.LongestIncreasingSubsequence;

public class Recursion {
    public int helper(int currInd, int prevInd, int[] nums) {
        if (currInd == nums.length)
            return 0;
        int notTake = helper(currInd + 1, prevInd, nums);
        int take = 0;
        if (prevInd == -1 || nums[currInd] > nums[prevInd])
            take = 1 + helper(currInd + 1, currInd, nums);
        return Math.max(take, notTake);
    }

    public int lengthOfLIS(int[] nums) {
        int currInd = 0;
        int prevInd = -1;
        return helper(currInd, prevInd, nums);
    }
}
