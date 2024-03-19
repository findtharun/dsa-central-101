package DynamicProgramming.DP2D.UniquePathsII;

public class SpaceOptimzation {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Initialize a 1D array to store results for the current row
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1)
            return 0;
        int[] dp = new int[n];

        // Base condition: If we are at the destination, there's only one way to reach
        dp[n - 1] = 1;

        // Traverse the grid from bottom-right to top-left
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    continue;
                }
                int down = 0;
                int right = 0;
                if (i + 1 < m && obstacleGrid[i][j] != 1)
                    down = dp[j];
                if (j + 1 < n && obstacleGrid[i][j] != 1)
                    right = dp[j + 1];
                dp[j] = down + right;
            }
        }
        return dp[0];
    }
}
