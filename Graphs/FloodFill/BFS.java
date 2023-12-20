package Graphs.FloodFill;

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

public class BFS {
    int prev = 0;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        boolean[][] visited = new boolean[n][m];

        prev = image[sr][sc]; // The Color which needs to be replaced
        bfs(sr, sc, color, visited, image);
        return image;
    }

    public void bfs(int sr, int sc, int color, boolean[][] visited, int[][] image) {
        int n = visited.length;
        int m = visited[0].length;

        image[sr][sc] = color; // Filling with desired color
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(sr, sc));
        int[] rowDir = { -1, 0, +1, 0 };
        int[] colDir = { 0, +1, 0, -1 };
        while (q.size() > 0) {
            Node curr = q.poll();
            int row = curr.row;
            int col = curr.col;
            // Traversing in Four Directions for Current Values
            for (int i = 0; i < 4; i++) {
                int nrow = row + rowDir[i];
                int ncol = col + colDir[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == prev
                        && visited[nrow][ncol] == false) {
                    visited[nrow][ncol] = true;
                    image[nrow][ncol] = color;
                    q.add(new Node(nrow, ncol));
                }
            }
        }

    }
}
