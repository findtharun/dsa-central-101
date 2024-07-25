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
        int destination = 30;
        Arrays.fill(moveVal, -1);
        for (int i = 0; i < 2 * N; i += 2)
            moveVal[arr[i]] = arr[i + 1]; // storing the moves in moves array
        // System.out.println(Arrays.toString(moves));
        if (moveVal[destination] != -1 && moveVal[destination] < destination)
            return -1;
        boolean[] visited = new boolean[31];
        Queue<Pair> q = new LinkedList<>(); // creating a queue of pairs
        q.add(new Pair(1, 0));
        visited[1] = true;
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int v = curr.v;
            int moves = curr.moves;
            for (int j = v + 1; j <= v + 6 && j <= destination; j++) {
                int nextV = j;
                if (moveVal[nextV] != -1) // Snake Or Ladder
                    nextV = moveVal[nextV];
                if (nextV == destination)
                    return moves + 1;
                if (!visited[nextV]) {
                    q.add(new Pair(nextV, moves + 1));
                    visited[nextV] = true;
                }
            }
        }
        return -1;
    }
}
