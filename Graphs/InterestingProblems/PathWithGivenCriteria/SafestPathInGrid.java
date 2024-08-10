package Graphs.InterestingProblems.PathWithGivenCriteria;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/find-the-safest-path-in-a-grid/
 * Explanation :
 */
class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Factor {
    int safeness;
    int row;
    int col;

    Factor(int safeness, int row, int col) {
        this.safeness = safeness;
        this.row = row;
        this.col = col;
    }
}

public class SafestPathInGrid {
    private static final int THIEF = 1;
    private static int[] rowDir = { 0, 0, 1, -1 };
    private static int[] colDir = { -1, 1, 0, 0 };

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] mat = new int[n][n];
        fillSafeness(mat, n, grid);

        // Initialize visited array
        boolean[][] visited = new boolean[n][n];

        // Priority Queue for BFS to maximize minimum safeness factor
        PriorityQueue<Factor> pq = new PriorityQueue<>((a, b) -> b.safeness - a.safeness);
        pq.add(new Factor(mat[0][0], 0, 0));
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            Factor curr = pq.poll();
            int currSafeness = curr.safeness;
            int row = curr.row;
            int col = curr.col;

            // Check if we reached the bottom-right corner
            if (row == n - 1 && col == n - 1) {
                return currSafeness;
            }

            for (int i = 0; i < 4; i++) {
                int nrow = row + rowDir[i];
                int ncol = col + colDir[i];
                if (isValidCell(mat, nrow, ncol) && visited[nrow][ncol] == false) {
                    visited[nrow][ncol] = true;
                    pq.add(new Factor(Math.min(currSafeness, mat[nrow][ncol]), nrow, ncol));
                }
            }
        }
        return -1;
    }

    public static void fillSafeness(int[][] mat, int n, List<List<Integer>> grid) {
        Queue<Pair> q = new LinkedList<>();
        // Multi-Source BFS from Thieves
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid.get(row).get(col) == THIEF) {
                    q.add(new Pair(row, col));
                    mat[row][col] = 0; // Distance from itself is zero
                } else {
                    mat[row][col] = Integer.MAX_VALUE; // Initialize with a large number
                }
            }
        }

        int[] rowDir = { -1, 1, 0, 0 };
        int[] colDir = { 0, 0, -1, 1 };

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int row = curr.row;
            int col = curr.col;

            for (int i = 0; i < 4; i++) {
                int nrow = row + rowDir[i];
                int ncol = col + colDir[i];

                if (isValidCell(mat, nrow, ncol)) {
                    // Only process the cell if a shorter path is found
                    if (mat[nrow][ncol] > mat[row][col] + 1) {
                        mat[nrow][ncol] = mat[row][col] + 1;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }

    public static boolean isValidCell(int[][] arr, int row, int col) {
        int len = arr.length;
        if (row < 0 || col < 0 || row >= len || col >= len)
            return false;
        return true;
    }
}
