package Graphs.BFS_DFS.SnakeNLadder;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int v;
    int moves;

    Pair(int v, int moves) {
        this.v = v;
        this.moves = moves;
    }
}

// https://leetcode.com/problems/snakes-and-ladders/
public class BoustrophedonStyle {
    public int[] getPos(int square, int n) {
        int row = (square - 1) / n;
        int col = (square - 1) % n;
        // Since We have alternating Sequence, If row is Odd we have to Transform column
        if (row % 2 == 1) {
            col = n - 1 - col;
        }
        // We always need to Transform Row because of Boustrophedon style
        row = n - 1 - row;
        return new int[] { row, col };
    }

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int destination = n * n;
        boolean[] visited = new boolean[destination + 1];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1, 0));
        visited[1] = true;
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int v = curr.v;
            int moves = curr.moves;
            for (int j = v + 1; j <= v + 6 && j <= destination; j++) {
                int[] pos = getPos(j, n); // Gives row and column of the
                int nextV = j;
                if (board[pos[0]][pos[1]] != -1) // Snake or Ladder
                    nextV = board[pos[0]][pos[1]];
                if (nextV == destination)
                    return moves + 1;
                if (visited[nextV] == false) {
                    q.add(new Pair(nextV, moves + 1));
                    visited[nextV] = true;
                }
            }
        }
        return -1;
    }
}
