package Arrays.GameOfLife;

public class SpaceOptimization {
    /*
     * 0 -> 0: 0
     * 1 -> 1: 1
     * 0 -> 1: 2
     * 1 -> 0: 3
     * 
     * 0s remain 0s, 1s remain 1s. If board[r][c] == 1 and count not in [2, 3], mark
     * 3.
     * If board[r][c] == 0 and count == 3: mark 2
     * Final loop: Flip 3s to 0, 2s to 1
     * Note getNeighbours function to be udpated to consider above formula
     */
    public int getNeighbours(int[][] board, int row, int col) {
        int neighbours = 0;
        int[] rowDir = { -1, 0, 1, 0, -1, -1, 1, 1 }; // URDL
        int[] colDir = { 0, 1, 0, -1, 1, -1, 1, -1 }; // URDL
        for (int i = 0; i < 8; i++) {
            int nrow = row + rowDir[i];
            int ncol = col + colDir[i];
            if (nrow < 0 || ncol < 0 || nrow >= board.length || ncol >= board[0].length)
                continue;
            if (board[nrow][ncol] == 1 || board[nrow][ncol] == 3) // Since we are Maksing Values using above logic
                neighbours++;
        }
        return neighbours;
    }

    public void gameOfLife(int[][] board) {
        int rowLen = board.length;
        int colLen = board[0].length;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                int neighbours = getNeighbours(board, i, j);
                if (board[i][j] == 1) {
                    if (neighbours < 2 || neighbours > 3) // Means it will go from live to dead
                        board[i][j] = 3;
                } else {
                    if (neighbours == 3)
                        board[i][j] = 2; // Dead to live means 2
                }
            }
        }
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (board[i][j] == 3)
                    board[i][j] = 0;
                if (board[i][j] == 2)
                    board[i][j] = 1;
            }
        }
    }
}