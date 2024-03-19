package DynamicProgramming.DP2D.UniquePathsII;

public class Memoization {
    public int helper(int row, int col, int[][] dp, int m, int n, int[][] obstacleGrid) {
        if (row == m - 1 && col == n - 1)
            return 1;
        if (row >= m || col >= n || obstacleGrid[row][col] == 1)
            return 0;
        if (dp[row][col] != 0)
            return dp[row][col];
        return dp[row][col] = helper(row + 1, col, dp, m, n, obstacleGrid)
                + helper(row, col + 1, dp, m, n, obstacleGrid);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1)
            return 0;
        int[][] dp = new int[m][n];
        return helper(0, 0, dp, m, n, obstacleGrid);

    }
}
