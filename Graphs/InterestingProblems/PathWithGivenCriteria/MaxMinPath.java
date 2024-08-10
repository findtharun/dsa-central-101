package Graphs.InterestingProblems.PathWithGivenCriteria;

import java.util.PriorityQueue;

/**
 * Path With Maximum Minimum Value :
 * https://leetcode.com/problems/path-with-maximum-minimum-value/description/
 * Find Maximum Value among all Minimum Paths
 */
class Tuple {
    int val;
    int row;
    int col;

    public Tuple(int val, int row, int col) {
        this.val = val;
        this.row = row;
        this.col = col;
    }
}

public class MaxMinPath {
    public int maximumMinimumPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] rowDir = { -1, 0, 0, 1 };
        int[] colDir = { 0, -1, 1, 0 };
        // We need PAth Such That
        PriorityQueue<Tuple> maxHeap = new PriorityQueue<>((a, b) -> b.val - a.val);
        boolean[][] visited = new boolean[m][n];
        maxHeap.add(new Tuple(grid[0][0], 0, 0));
        visited[0][0] = true;
        while (!maxHeap.isEmpty()) {
            Tuple curr = maxHeap.poll();
            int row = curr.row;
            int col = curr.col;
            int val = curr.val;
            if (row == m - 1 && col == n - 1)
                return val;
            for (int i = 0; i < 4; i++) {
                int nrow = row + rowDir[i];
                int ncol = col + colDir[i];
                if (nrow < 0 || ncol < 0 || nrow >= m || ncol >= n ||
                        visited[nrow][ncol] == true) {
                    continue;
                }
                visited[nrow][ncol] = true;
                maxHeap.add(new Tuple(Math.min(grid[nrow][ncol], val), nrow, ncol));
            }
        }
        return -1;
    }
}
