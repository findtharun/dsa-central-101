package DynamicProgramming.DP2D.UniquePathsII;

public class Tabulation {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // If there is obstacle at Target, There are no ways
        if (obstacleGrid[m - 1][n - 1] == 1)
            return 0;
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = 1;
        for (int row = m - 1; row >= 0; row--) {
            for (int col = n - 1; col >= 0; col--) {
                if (row == m - 1 && col == n - 1) {
                    continue;
                }
                if (obstacleGrid[row][col] != 1) {
                    int down = 0;
                    int right = 0;
                    if (col + 1 < n)
                        right = dp[row][col + 1];
                    if (row + 1 < m)
                        down = dp[row + 1][col];
                    dp[row][col] = down + right;
                }
            }
        }
        return dp[0][0];
    }
}
