package Recursion_Backtracking.BackTracking;

public class SudokuSolver {
    public static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == c)
                return false;
            if (board[row][i] == c)
                return false;
        }
        // grid
        int srg = (row / 3) * 3; // Starting row of Grid
        int scg = (col / 3) * 3; // Starting col of Grid
        for (int i = srg; i < srg + 3; i++) {
            for (int j = scg; j < scg + 3; j++) {
                if (board[i][j] == c) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return;
        solve(board);
    }
}
