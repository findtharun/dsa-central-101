package DynamicProgramming.DP2D.MinPathSumTriangle;

import java.util.List;

public class Recursion {
    public int helper(int row, int col, int n, List<List<Integer>> triangle) {
        if (row == n - 1)
            return triangle.get(n - 1).get(col);
        int firstMove = Integer.MAX_VALUE;
        int secondMove = Integer.MAX_VALUE;
        if (row + 1 < n && col < triangle.get(row + 1).size())
            firstMove = triangle.get(row).get(col) +
                    helper(row + 1, col, n, triangle);
        if (row + 1 < n && col + 1 < triangle.get(row + 1).size())
            secondMove = triangle.get(row).get(col) +
                    helper(row + 1, col + 1, n, triangle);
        return Math.min(firstMove, secondMove);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        return helper(0, 0, n, triangle);
    }
}
