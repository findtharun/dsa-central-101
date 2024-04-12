package DynamicProgramming;

public class CountSquareSubmatrices {
    /*
     * https://leetcode.com/problems/count-square-submatrices-with-all-ones/
     * Time : O(M*N)
     * Space : O(M*N)
     */
    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        // DP[i][j] gives number of squares ending at i,j
        for (int i = 0; i < rows; i++)
            dp[i][0] = matrix[i][0];
        for (int j = 0; j < cols; j++)
            dp[0][j] = matrix[0][j];
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0)
                    dp[i][j] = 0;
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ans += dp[i][j];
            }
        }
        return ans;
    }
}
