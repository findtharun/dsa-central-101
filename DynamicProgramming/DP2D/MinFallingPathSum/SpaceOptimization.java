package DynamicProgramming.DP2D.MinFallingPathSum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpaceOptimization {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if (n == 1)
            return matrix[0][0];
        List<Integer> next = new ArrayList<>(Collections.nCopies(n, 0));
        List<Integer> curr = new ArrayList<>(Collections.nCopies(n, 0));
        for (int col = 0; col < n; col++)
            next.set(col, matrix[n - 1][col]);
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col < n; col++) {
                int down = matrix[row][col] + next.get(col);
                int leftDiag = Integer.MAX_VALUE;
                int rightDiag = Integer.MAX_VALUE;
                if (col - 1 >= 0)
                    leftDiag = matrix[row][col] + next.get(col - 1);
                if (col + 1 < n)
                    rightDiag = matrix[row][col] + next.get(col + 1);
                curr.set(col, Math.min(down, Math.min(leftDiag, rightDiag)));
            }
            next = new ArrayList<>(curr);
        }
        int res = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            res = Math.min(curr.get(col), res);
        }
        return res;
    }
}
