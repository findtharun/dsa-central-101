package DynamicProgramming.DP2D.MinPathSumTriangle;

import java.util.List;

public class Tabulation {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];
        for (int col = 0; col < n; col++) {
            dp[n - 1][col] = triangle.get(n - 1).get(col);
        }
        for (int row = n - 2; row >= 0; row--) {
            for (int col = row; col >= 0; col--) {
                int downMove = triangle.get(row).get(col) + dp[row + 1][col];
                int diagonalMove = triangle.get(row).get(col) + dp[row + 1][col + 1];
                dp[row][col] = Math.min(downMove, diagonalMove);
            }
        }
        return dp[0][0];
    }
}
