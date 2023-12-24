package Graphs.MultiSourceDFS;
// https://leetcode.com/problems/surrounded-regions/description/
public class SuuroundedRegions {
    int[] rowDir = { -1, 0, +1, 0 };
    int[] colDir = { 0, +1, 0, -1 };

    public void dfs(int row, int col, boolean[][] visited, char[][] board) {
        visited[row][col] = true; // These cells can not be flipped
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < 4; i++) {
            int nrow = row + rowDir[i];
            int ncol = col + colDir[i];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                    visited[nrow][ncol] == false && board[nrow][ncol] == 'O') {
                // These cells can not be flipped
                dfs(nrow, ncol, visited, board);
            }
        }
    }

    public void solve(char[][] board) {
        // Boundary Os and Their connected ones ccan not be surrounded Completely by
        // X,Hence Traverse from Boundaries and Mark them as Can not be Flipped.

        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        // Traversing First Row and Last Row
        for (int col = 0; col < m; col++) {
            // First Row
            if (visited[0][col] == false && board[0][col] == 'O')
                dfs(0, col, visited, board);
            // Last Row
            if (visited[n - 1][col] == false && board[n - 1][col] == 'O')
                dfs(n - 1, col, visited, board);
        }
        // Traversing First Column and Last Column
        for (int row = 0; row < n; row++) {
            // First Column
            if (visited[row][0] == false && board[row][0] == 'O')
                dfs(row, 0, visited, board);
            if (visited[row][m - 1] == false && board[row][m - 1] == 'O')
                dfs(row, m - 1, visited, board);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == false && board[i][j] == 'O') {
                    // These are the Cells which are not connected to Boundary Os, Can be flipped
                    board[i][j] = 'X';
                }
            }
        }
    }
}
