package Graphs.ShortestPathAlgorithms.Djskstra.Basics;

import java.util.PriorityQueue;

class tuple {
    int distance;
    int row;
    int col;

    tuple(int distance, int row, int col) {
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}

public class PathWithMinEffort {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = (int) 1e9;
            }
        }
        PriorityQueue<tuple> pq = new PriorityQueue<tuple>((x, y) -> x.distance - y.distance);
        pq.add(new tuple(0, 0, 0));
        dist[0][0] = 0;
        int[] rowDir = { -1, 0, 1, 0 };
        int[] colDir = { 0, 1, 0, -1 };

        while (pq.size() > 0) {
            tuple curr = pq.poll();
            int diff = curr.distance;
            int row = curr.row;
            int col = curr.col;

            for (int i = 0; i < 4; i++) {
                int newRow = row + rowDir[i];
                int newCol = col + colDir[i];
                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m) {
                    int newEffort = Math.max(Math.abs(heights[row][col] - heights[newRow][newCol]), diff);
                    if (newEffort < dist[newRow][newCol]) {
                        dist[newRow][newCol] = newEffort;
                        pq.add(new tuple(newEffort, newRow, newCol));
                    }
                }
            }
        }
        return dist[n - 1][m - 1] == 1e9 ? 0 : dist[n - 1][m - 1];
    }
}
