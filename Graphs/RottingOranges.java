package Graphs;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/rotting-oranges/description/
class Node {
    int row;
    int col;
    int time;

    Node(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int[] rowDir = { -1, 0, +1, 0 };
        int[] colDir = { 0, +1, 0, -1 };
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] rotted = new boolean[n][m]; // This for Keeping Track of Rottened

        int count_fresh = 0;
        // We first check for Rotten ones, add to Queue and Perform BFS
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    count_fresh++;
                if (grid[i][j] == 2) {
                    q.add(new Node(i, j, 0));
                    rotted[i][j] = true;
                }
            }
        }
        if (count_fresh == 0)
            return 0; // All are rotted
        int maxTime = 0;
        int rottedWithTime = 0;
        while (q.size() > 0) {
            Node curr = q.poll();
            int row = curr.row;
            int col = curr.col;
            int time = curr.time;
            maxTime = Math.max(time, maxTime);
            for (int i = 0; i < 4; i++) {
                int nrow = row + rowDir[i];
                int ncol = col + colDir[i];
                // Checking for Not Rotted and Calcualting Time
                if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m &&
                        rotted[nrow][ncol] == false && grid[nrow][ncol] == 1) {
                    q.add(new Node(nrow, ncol, time + 1));
                    rotted[nrow][ncol] = true; // Marking them as rottened
                    rottedWithTime++;
                }
            }
        }
        if (count_fresh != rottedWithTime)
            return -1;
        return maxTime;
    }
}
