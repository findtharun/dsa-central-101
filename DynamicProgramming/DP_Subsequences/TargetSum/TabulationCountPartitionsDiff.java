package DynamicProgramming.DP_Subsequences.TargetSum;

public class TabulationCountPartitionsDiff {
    public int findTargetSumWays(int[] nums, int S) {
        int numsSum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++)
            numsSum += nums[i];
        if (numsSum - S < 0)
            return 0;
        if ((numsSum - S) % 2 != 0)
            return 0;
        int targetSum = (numsSum - S) / 2;
        int[][] dp = new int[n][targetSum + 1];
        for (int i = 0; i < n; i++)
            dp[i][0] = 1;
        if (nums[0] == 0)
            dp[0][0] = 2;
        if (nums[0] <= targetSum && nums[0] != 0)
            dp[0][nums[0]] = 1;
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= targetSum; target++) {
                int notTake = dp[ind - 1][target];
                int take = 0;
                if (nums[ind] <= target)
                    take = dp[ind - 1][target - nums[ind]];
                dp[ind][target] = (take + notTake);
            }
        }
        return dp[n - 1][targetSum];
    }
}
