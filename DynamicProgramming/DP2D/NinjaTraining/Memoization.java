package DynamicProgramming.DP2D.NinjaTraining;

import java.util.Arrays;

// helper(n-1,1) --> Give me the Merit Points from 0 to n-1 Days if Ninja Performs 1st task on last day (i.e - n)
// helper(n-1,3) --> No task is Performed Yet on that day
public class Memoization {
    public static int helper(int day, int lastCompletedTask, int[][] points, int[][] dp) {
        if (day == 0) {
            int maxi = 0;
            for (int task = 0; task < 3; task++) {
                if (task != lastCompletedTask)
                    maxi = Math.max(maxi, points[0][task]);
            }
            return dp[day][lastCompletedTask] = maxi;
        }
        if (dp[day][lastCompletedTask] != -1)
            return dp[day][lastCompletedTask];
        int maxi = 0;
        for (int task = 0; task < 3; task++) {
            if (task != lastCompletedTask) {
                int currPoints = points[day][task] + helper(day - 1, task, points, dp);
                maxi = Math.max(currPoints, maxi);
            }
        }
        return dp[day][lastCompletedTask] = maxi;
    }

    public static int ninjaTraining(int n, int points[][]) {
        int[][] dp = new int[n][4];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return helper(n - 1, 3, points, dp);
    }
}
