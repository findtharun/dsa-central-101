package DynamicProgramming.DP1D.MaxSumNonAdjacentSubsequence;

import java.util.ArrayList;

public class Recursion {
    public static int solve(int idx, ArrayList<Integer> nums, int n) {
        if (idx == 0)
            return nums.get(idx);
        if (idx < 0)
            return 0;

        int pick = nums.get(idx) + solve(idx - 2, nums, n);
        int notPick = 0 + solve(idx - 1, nums, n);
        return Math.max(pick, notPick);
    }

    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        // Write your code here.
        int res = solve(nums.size() - 1, nums, nums.size());
        return res;
    }
}
