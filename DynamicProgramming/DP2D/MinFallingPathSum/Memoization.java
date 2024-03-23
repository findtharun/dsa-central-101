package DynamicProgramming.DP2D.MinFallingPathSum;

import java.util.Arrays;

public class Memoization {
    public int helper(int row, int col, int[][] matrix, int[][] dp) {
        if (row == matrix.length - 1)
            return matrix[row][col]; // Since Min Path to itself is the value
        if (dp[row][col] != Integer.MAX_VALUE)
            return dp[row][col];
        int leftDiag = Integer.MAX_VALUE;
        int rightDiag = Integer.MAX_VALUE;
        int down = matrix[row][col] + helper(row + 1, col, matrix, dp);
        if (col - 1 >= 0)
            leftDiag = matrix[row][col] + helper(row + 1, col - 1, matrix, dp);
        if (col + 1 < matrix.length)
            rightDiag = matrix[row][col] + helper(row + 1, col + 1, matrix, dp);
        return dp[row][col] = Math.min(down, Math.min(leftDiag, rightDiag));
    }

    public int minFallingPathSum(int[][] matrix) {
        // We can start at any Column from First row and Reach any Column in Last Low
        int n = matrix.length;
        int minPathSum = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];
        for (int[] row : dp)
            Arrays.fill(row, Integer.MAX_VALUE);
        for (int col = 0; col < n; col++) {
            minPathSum = Math.min(minPathSum, helper(0, col, matrix, dp));
        }
        return minPathSum;
    }
}
