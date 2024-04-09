package DynamicProgramming.DP_LIS.LongestIncreasingSubsequence;

public class SpaceOptimization {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // Since To Store -1, We are increasing all Indices by 1
        int[] next = new int[n + 1];
        int[] curr = new int[n + 1];
        for (int currInd = n - 1; currInd >= 0; currInd--) {
            for (int prevInd = currInd - 1; prevInd >= -1; prevInd--) {
                int notTake = next[prevInd + 1]; // -1+1 = 0;
                int take = 0;
                if (prevInd == -1 || nums[currInd] > nums[prevInd])
                    take = 1 + next[currInd + 1]; // We always do +1 to accomodate -1 for prevInd
                curr[prevInd + 1] = Math.max(take, notTake);
            }
            next = curr.clone();
        }
        return next[-1 + 1];
    }
}
