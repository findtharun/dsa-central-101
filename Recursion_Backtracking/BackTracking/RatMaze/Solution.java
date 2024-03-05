package Recursion_Backtracking.BackTracking.RatMaze;
// https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
import java.util.*;

// m is the given matrix and n is the order of matrix
public class Solution {
    public static void solve(int row, int col, int[][] m, int n, ArrayList<String> res, String move, boolean[][] vis) {
        if (row == n - 1 && col == n - 1) {
            res.add(move);
            return;
        }
        // Since we Need result Lexographically , we try to have lexographic moves as
        // priority i.e DLRU
        // Downwards
        if (row + 1 < n && vis[row + 1][col] == false && m[row + 1][col] == 1) {
            vis[row][col] = true;
            solve(row + 1, col, m, n, res, move + 'D', vis);
            vis[row][col] = false;
        }
        // Left
        if (col - 1 >= 0 && vis[row][col - 1] == false && m[row][col - 1] == 1) {
            vis[row][col] = true;
            solve(row, col - 1, m, n, res, move + 'L', vis);
            vis[row][col] = false;
        }
        // Right
        if (col + 1 < n && vis[row][col + 1] == false && m[row][col + 1] == 1) {
            vis[row][col] = true;
            solve(row, col + 1, m, n, res, move + 'R', vis);
            vis[row][col] = false;
        }
        if (row - 1 >= 0 && vis[row - 1][col] == false && m[row - 1][col] == 1) {
            vis[row][col] = true;
            solve(row - 1, col, m, n, res, move + 'U', vis);
            vis[row][col] = false;
        }

    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> res = new ArrayList<>();
        boolean[][] vis = new boolean[n][n];
        if (m[0][0] == 1)
            solve(0, 0, m, n, res, "", vis);
        return res;
    }
}
