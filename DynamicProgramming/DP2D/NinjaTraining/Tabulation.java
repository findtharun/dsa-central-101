package DynamicProgramming.DP2D.NinjaTraining;

public class Tabulation {
    public static int ninjaTraining(int n, int[][] points) {
        // Initialize a 2D array 'dp' to store the maximum points
        int[][] dp = new int[n][4];

        // Initialize the first day's maximum points based on the available choices
        dp[0][0] = Math.max(points[0][1], points[0][2]); // 0th Task Performed
        dp[0][1] = Math.max(points[0][0], points[0][2]); // 1st Task Performed
        dp[0][2] = Math.max(points[0][0], points[0][1]); // 2nd Task Performed
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2])); // If there is no activity Performed on
                                                                                 // that day

        // Iterate through each day and each activity
        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                // Consider each possible task for the current day
                for (int task = 0; task <= 2; task++) {
                    if (task != last) { // Ensure that the current task is different from the last
                        // Calculate the points for the current activity and add it to the maximum
                        // points from the previous day
                        int activity = points[day][task] + dp[day - 1][task];
                        // Update the maximum points for the current day and last activity
                        dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }
            }
        }

        // Return the maximum points achievable after all days
        return dp[n - 1][3];
    }
}
