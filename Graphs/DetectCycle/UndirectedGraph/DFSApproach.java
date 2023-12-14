package Graphs.DetectCycle.UndirectedGraph;

import java.util.ArrayList;

public class DFSApproach {
    boolean checkForCycle(int node, int parent, boolean vis[], ArrayList<ArrayList<Integer>> adj) {
        // Mark the current node as visited
        vis[node] = true;

        // Traverse through all adjacent nodes
        for (int neighbour : adj.get(node)) {
            // If the adjacent node is not visited, recursively check for a cycle
            if (vis[neighbour] == false) {
                if (checkForCycle(neighbour, node, vis, adj) == true)
                    return true;
            }
            // If the adjacent node is visited and not the parent of the current node, there
            // is a cycle
            else if (neighbour != parent)
                return true;
        }

        // If no cycle is found, return false
        return false;
    }

    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];

        // Iterate through all vertices of the graph
        for (int i = 0; i < V; i++) {
            // If a vertex is not visited, check for a cycle starting from that vertex
            if (vis[i] == false) {
                if (checkForCycle(i, -1, vis, adj))
                    return true;
            }
        }

        // If no cycle is found in any vertex, return false
        return false;
    }
}
