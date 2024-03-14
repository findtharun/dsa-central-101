package DynamicProgramming.DP1D;
// https://leetcode.com/problems/min-cost-climbing-stairs/
public class MinCostClimbingStairs {
    // Here Floor represents step after last stair, Question not Framed correctly
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // If there are less than 2 steps, the minimum cost is 0
        if (n < 2) {
            return 0;
        }

        // dp[i] will store the minimum cost to reach Top from that Step
        int[] dp = new int[n + 1];
        dp[n] = 0; // Floor
        dp[n - 1] = cost[n - 1];

        // Start from the 2nd Last stair and calculate the minimum cost to reach the Top
        for (int i = n - 2; i >= 0; i--) {
            // To reach the ith step, you can either come from (i+1)th or (i+2)th step,
            // so take the minimum of those two and add the cost of the ith step
            dp[i] = Math.min(dp[i + 1], dp[i + 2]) + cost[i];
        }
        return Math.min(dp[0], dp[1]);
    }
}
