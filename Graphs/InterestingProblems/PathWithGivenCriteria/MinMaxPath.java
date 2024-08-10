package Graphs.InterestingProblems.PathWithGivenCriteria;

import java.util.PriorityQueue;

/**
 * Path With Minimum Maximum Value :
 * https://leetcode.com/problems/swim-in-rising-water/
 * Find Path which contains Min Value such that It is Minium among all max Paths
 */

class Tuple {
    int maxWt;
    int row;
    int col;

    public Tuple(int maxWt, int row, int col) {
        this.maxWt = maxWt;
        this.row = row;
        this.col = col;
    }
}

public class MinMaxPath {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[] rowDir = { -1, 0, 0, 1 };
        int[] colDir = { 0, -1, 1, 0 };
        // We need PAth Such That
        PriorityQueue<Tuple> minHeap = new PriorityQueue<>((a, b) -> a.maxWt - b.maxWt);
        boolean[][] visited = new boolean[n][n];
        minHeap.add(new Tuple(grid[0][0], 0, 0));
        visited[0][0] = true;
        while (!minHeap.isEmpty()) {
            Tuple curr = minHeap.poll();
            int row = curr.row;
            int col = curr.col;
            int wt = curr.maxWt;
            if (row == n - 1 && col == n - 1)
                return wt;
            for (int i = 0; i < 4; i++) {
                int nrow = row + rowDir[i];
                int ncol = col + colDir[i];
                if (nrow < 0 || ncol < 0 || nrow >= n || ncol >= n ||
                        visited[nrow][ncol] == true) {
                    continue;
                }
                visited[nrow][ncol] = true;
                minHeap.add(new Tuple(Math.max(grid[nrow][ncol], wt), nrow, ncol));
            }
        }
        return -1;
    }
}
