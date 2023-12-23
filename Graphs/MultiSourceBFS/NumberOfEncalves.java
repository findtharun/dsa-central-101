package Graphs.MultiSourceBFS;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int row;
    int col;

    Node(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class NumberOfEncalves {
    // Enclaves are the Lands which does not have path to Exit from lands, Hence we
    // use BFS and find all connected lands , return the unconnected lands
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];

        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Finding boundary 1s
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    if (grid[i][j] == 1) {
                        q.add(new Node(i, j));
                        visited[i][j] = 1;
                    }
                }
            }
        }
        int[] rowDir = { -1, 0, +1, 0 };
        int[] colDir = { 0, +1, 0, -1 };
        while (q.size() > 0) {
            Node curr = q.poll();
            int row = curr.row;
            int col = curr.col;
            for (int i = 0; i < 4; i++) {
                int nrow = row + rowDir[i];
                int ncol = col + colDir[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                        visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    visited[nrow][ncol] = 1;
                    q.add(new Node(nrow, ncol));
                }
            }
        }
        int enclaves = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    enclaves++;
                }
            }
        }
        return enclaves;
    }
}
