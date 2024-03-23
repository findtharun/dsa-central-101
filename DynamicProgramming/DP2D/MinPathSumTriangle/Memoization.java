package DynamicProgramming.DP2D.MinPathSumTriangle;

import java.util.Arrays;
import java.util.List;

public class Memoization {
    public int helper(int row, int col, int[][] dp, int n, List<List<Integer>> triangle) {
        if (dp[row][col] != -1)
            return dp[row][col];
        if (row == n - 1)
            return triangle.get(n - 1).get(col);
        int downMove = Integer.MAX_VALUE;
        int diagonalMove = Integer.MAX_VALUE;
        if (row + 1 < n && col < triangle.get(row + 1).size())
            downMove = triangle.get(row).get(col) +
                    helper(row + 1, col, dp, n, triangle);
        if (row + 1 < n && col + 1 < triangle.get(row + 1).size())
            diagonalMove = triangle.get(row).get(col) +
                    helper(row + 1, col + 1, dp, n, triangle);
        return dp[row][col] = Math.min(downMove, diagonalMove);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return helper(0, 0, dp, n, triangle);
    }
}
