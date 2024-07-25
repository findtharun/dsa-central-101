package Graphs.BFS_DFS.SnakeNLadder;

import java.util.Arrays;
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

// https://www.geeksforgeeks.org/problems/snake-and-ladder-problem4816/1
public class DefaultStyle {
    public static int minThrow(int N, int arr[]) {
        int[] moveVal = new int[31];
        Arrays.fill(moveVal, -1);
        for (int i = 0; i < 2 * N; i += 2)
            moveVal[arr[i]] = arr[i + 1]; // storing the moves in moves array
        // System.out.println(Arrays.toString(moves));
        if (moveVal[30] != -1 && moveVal[30] < 30)
            return -1;
        boolean[] visited = new boolean[31];
        Queue<Pair> q = new LinkedList<>(); // creating a queue of pairs
        q.add(new Pair(1, 0));
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int v = curr.v;
            int moves = curr.moves;
            if (v == 30)
                return moves;
            for (int j = v + 1; j <= v + 6 && j <= 30; j++) {
                if (visited[j] == false) {
                    visited[j] = true;
                    if (moveVal[j] != -1) {
                        // If Snake or Ladder is found
                        q.add(new Pair(moveVal[j], moves + 1));

                    } else {
                        // If no Snake or Ladder
                        q.add(new Pair(j, moves + 1));
                    }
                }
            }
        }
        return -1;
    }
}
