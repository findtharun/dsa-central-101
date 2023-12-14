package Graphs;
// https://practice.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1-1587115620/1
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int row;
    int col;
    int steps;

    Node(int row, int col, int steps) {
        this.row = row;
        this.col = col;
        this.steps = steps;
    }
}

public class DistanceOfNearestCell {
    public int[][] nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] dist = new int[n][m];
        Queue<Node> q = new LinkedList<>();

        // We find 1s first and Perform BFS
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    visited[i][j] = true;
                    q.add(new Node(i, j, 0)); // Since if the value is 1, O steps are needed for nearest 1
                }
            }
        }

        // Since we need to Travel in Four Directions
        int[] rowDir = { -1, 0, +1, 0 };
        int[] colDir = { 0, +1, 0, -1 };

        // BFS on every queue Item
        while (q.size() > 0) {
            Node curr = q.poll();
            int row = curr.row;
            int col = curr.col;
            int steps = curr.steps;
            dist[row][col] = steps;

            for (int i = 0; i < 4; i++) {
                int nrow = row + rowDir[i];
                int ncol = col + colDir[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == false) {
                    visited[nrow][ncol] = true;
                    q.add(new Node(nrow, ncol, steps + 1));
                }
            }
        }
        return dist;

    }
}
