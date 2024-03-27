package DynamicProgramming.DP_Subsequences.TargetSum;

public class Recursion {
    int helper(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (S == sum)
                return 1;
            return 0;
        }
        // Positive
        int pos = helper(nums, i + 1, sum + nums[i], S);
        // Negative
        int neg = helper(nums, i + 1, sum - nums[i], S);

        return pos + neg;
    }

    public int findTargetSumWays(int[] nums, int S) {
        // int[][] dp = new int[nums.length][S+1]
        return helper(nums, 0, 0, S);
    }
}
