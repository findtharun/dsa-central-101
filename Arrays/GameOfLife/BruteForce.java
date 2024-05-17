package Arrays.GameOfLife;

public class BruteForce {
    public int getNeighbours(int[][] board, int row, int col) {
        int neighbours = 0;
        int[] rowDir = { -1, 0, 1, 0, -1, -1, 1, 1 }; // URDL
        int[] colDir = { 0, 1, 0, -1, 1, -1, 1, -1 }; // URDL
        for (int i = 0; i < 8; i++) {
            int nrow = row + rowDir[i];
            int ncol = col + colDir[i];
            if (nrow < 0 || ncol < 0 || nrow >= board.length || ncol >= board[0].length)
                continue;
            if (board[nrow][ncol] == 1)
                neighbours++;
        }
        return neighbours;
    }

    public void gameOfLife(int[][] board) {
        int rowLen = board.length;
        int colLen = board[0].length;
        // By Default all values in res are 0
        int[][] res = new int[rowLen][colLen];
        /*
         * For Live Cell if Neighbours are == 2 or 3 Then It would live
         * Rest all conditions we no need to check as res(i,j) would be 0 if above is
         * not satisfied
         * For Dead Cell We check whether neighbours are == 3
         */
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                int neighbours = getNeighbours(board, i, j);
                if (board[i][j] == 1) {
                    if (neighbours == 2 || neighbours == 3)
                        res[i][j] = 1;
                } else {
                    if (neighbours == 3) {
                        res[i][j] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                board[i][j] = res[i][j];
            }
        }
    }
}
