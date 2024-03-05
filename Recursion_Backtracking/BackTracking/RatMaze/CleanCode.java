package Recursion_Backtracking.BackTracking.RatMaze;

import java.util.ArrayList;

public class CleanCode {
    public static void solve(int row, int col, int[][] m, int n, ArrayList<String> res, String move, boolean[][] vis,
            int[] rowDir, int[] colDir) {
        if (row == n - 1 && col == n - 1) {
            res.add(move);
            return;
        }
        String dir = "DLRU";
        for (int i = 0; i < 4; i++) {
            int nextRow = row + rowDir[i];
            int nextCol = col + colDir[i];
            if (nextRow >= 0 && nextCol >= 0 && nextRow < n && nextCol < n && vis[nextRow][nextCol] == false
                    && m[nextRow][nextCol] == 1) {
                vis[row][col] = true;
                solve(nextRow, nextCol, m, n, res, move + dir.charAt(i), vis, rowDir, colDir);
                vis[row][col] = false;
            }
        }

    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> res = new ArrayList<>();
        boolean[][] vis = new boolean[n][n];
        // Since we Need result Lexographically , we try to have lexographic moves as
        // priority i.e DLRU
        int[] rowDir = { 1, 0, 0, -1 };
        int[] colDir = { 0, -1, 1, 0 };
        if (m[0][0] == 1)
            solve(0, 0, m, n, res, "", vis, rowDir, colDir);
        return res;
    }
}
