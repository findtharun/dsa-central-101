package DynamicProgramming.DP2D.MinPathSumTriangle;

import java.util.List;

public class SpaceOptimization {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] front = new int[n]; // Stores the results for the current row (We Traverse From Last to First)
        int[] curr = new int[n]; // Stores the results for the next row

        // Initialize the front array with the values from the bottom row of the
        // triangle
        for (int j = 0; j < n; j++) {
            front[j] = triangle.get(n - 1).get(j);
        }

        for (int row = n - 2; row >= 0; row--) {
            for (int col = row; col >= 0; col--) {
                int downMove = triangle.get(row).get(col) + front[col];
                int diagonalMove = triangle.get(row).get(col) + front[col + 1];
                curr[col] = Math.min(downMove, diagonalMove);
            }
            front = curr.clone();
        }
        return front[0];
    }
}
