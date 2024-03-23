package DynamicProgramming.DP2D.MinFallingPathSum;

public class Tabulation {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int col = 0; col < n; col++) {
            dp[n - 1][col] = matrix[n - 1][col];
        }
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col < n; col++) {
                int down = matrix[row][col] + dp[row + 1][col];
                int leftDiag = Integer.MAX_VALUE;
                int rightDiag = Integer.MAX_VALUE;
                if (col - 1 >= 0)
                    leftDiag = matrix[row][col] + dp[row + 1][col - 1];
                if (col + 1 < n)
                    rightDiag = matrix[row][col] + dp[row + 1][col + 1];
                dp[row][col] = Math.min(down, Math.min(leftDiag, rightDiag));
            }
        }
        int res = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            res = Math.min(dp[0][col], res);
        }
        return res;
    }
}
