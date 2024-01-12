package Graphs.BFS_DFS.BiPartiteGraph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length; // Given Adjacency List
        int[] color = new int[V];
        Arrays.fill(color, -1);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) { // Graph may have Multiple Compoments, Hence a For Loop
            if (color[i] == -1) {
                q.add(i);
                color[i] = 0;
                while (q.size() > 0) {
                    int curr_node = q.poll();
                    for (int neighbour : graph[curr_node]) {
                        if (color[neighbour] == -1) {
                            color[neighbour] = 1 - color[curr_node];
                            q.add(neighbour);
                        } else if (color[neighbour] == color[curr_node])
                            return false;
                    }
                }
            }
        }
        return true;
    }
}
