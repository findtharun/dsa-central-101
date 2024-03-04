package Recursion_Backtracking.BackTracking.NQueens;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Optimal {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        int leftRow[] = new int[n];
        int leftUpperDiagonal[] = new int[2 * n - 1];
        int leftLowerDiagonal[] = new int[2 * n - 1];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<List<String>>();
        solve(0, board, res, leftRow, leftLowerDiagonal, leftUpperDiagonal);
        return res;
    }

    static void solve(int col, char[][] board, List<List<String>> res, int leftRow[], int leftLowerDiagonal[],
            int leftUpperDiagonal[]) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (leftRow[row] == 0 && leftLowerDiagonal[row + col] == 0
                    && leftUpperDiagonal[board.length - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                leftLowerDiagonal[row + col] = 1;
                leftUpperDiagonal[board.length - 1 + col - row] = 1;
                solve(col + 1, board, res, leftRow, leftLowerDiagonal, leftUpperDiagonal);
                board[row][col] = '.';
                leftRow[row] = 0;
                leftLowerDiagonal[row + col] = 0;
                leftUpperDiagonal[board.length - 1 + col - row] = 0;
            }
        }
    }

    static List<String> construct(char[][] board) {
        List<String> currBoard = new LinkedList<String>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            currBoard.add(s);
        }
        return currBoard;
    }
}
