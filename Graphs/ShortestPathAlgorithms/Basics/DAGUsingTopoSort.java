package Graphs.ShortestPathAlgorithms.Basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/* Time Complexity: O(N+M) {for the topological sort} + O(N+M) {for relaxation of vertices, each node and its adjacent nodes get traversed} ~ O(N+M). */
class Pair {
    int node;
    int weight;

    Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

// Whenever you examine the node n in a topological ordering, you have the
// guarantee that you've already traversed every possible path to n.
// Using this it's clear to see that you can generate the shortest path with one
// linear scan of a topological ordering
public class DAGUsingTopoSort {
    public void topoSort(int curr_node, ArrayList<ArrayList<Pair>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[curr_node] = true;
        for (int i = 0; i < adj.get(curr_node).size(); i++) {
            int neighbour = adj.get(curr_node).get(i).node;
            if (visited[neighbour] == false)
                topoSort(neighbour, adj, visited, stack);
        }
        stack.push(curr_node);
    }

    public int[] shortestPath(int N, int M, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            ArrayList<Pair> temp = new ArrayList<>();
            adj.add(temp);
        }
        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }
        // We Perform TopoSort and Then Traverse for Shortest Path
        boolean[] visited = new boolean[N];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (visited[i] == false)
                topoSort(i, adj, visited, stack);
        }
        int[] dist = new int[N];
        Arrays.fill(dist, (int) (1e9));
        dist[0] = 0;
        while (!stack.isEmpty()) {
            int curr_node = stack.pop();
            for (int i = 0; i < adj.get(curr_node).size(); i++) {
                int v = adj.get(curr_node).get(i).node;
                int wt = adj.get(curr_node).get(i).weight;

                if (dist[curr_node] + wt < dist[v])
                    dist[v] = dist[curr_node] + wt;

            }
        }
        for (int i = 0; i < N; i++) {
            if (dist[i] == (int) (1e9))
                dist[i] = -1;
        }
        return dist;
    }
}
