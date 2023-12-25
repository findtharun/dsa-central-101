package Graphs.ShortestPathAlgorithms.Basics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class UndirectedGraph {
    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        // Creating Adjacency List
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        // n - Number of Nodes
        // m - Number of Edges
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[n];
        for (int i = 0; i < n; i++)
            dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;
        q.add(src);
        // We always take the Minimum Distance
        while (!q.isEmpty()) {
            int curr_node = q.peek();
            q.poll();
            for (int neighbour : adj.get(curr_node)) {
                if (dist[curr_node] + 1 < dist[neighbour]) {
                    dist[neighbour] = dist[curr_node] + 1;
                    q.add(neighbour);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                dist[i] = -1;
        }
        return dist;
    }
}
