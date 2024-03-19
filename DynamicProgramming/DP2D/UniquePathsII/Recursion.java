package DynamicProgramming.DP2D.UniquePathsII;

public class Recursion {
    public static int helper(int row, int col, int m, int n) {
        if (row >= m || col >= n)
            return 0;
        if (row == m - 1 && col == n - 1)
            return 1;
        return helper(row, col + 1, m, n) + helper(row + 1, col, m, n);
    }

    public int uniquePaths(int m, int n) {
        int res = helper(0, 0, m, n);
        return res;
    }
}
