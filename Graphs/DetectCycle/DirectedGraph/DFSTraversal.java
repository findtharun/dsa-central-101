package Graphs.DetectCycle.DirectedGraph;

import java.util.ArrayList;

// Explanation : https://www.youtube.com/watch?v=9twcmtQj4DU
public class DFSTraversal {

    public boolean checkCycle(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] pathVisited) {

        visited[node] = true;
        pathVisited[node] = true;
        for (int neighbour : adj.get(node)) {
            if (!visited[neighbour]) {
                if (checkCycle(neighbour, adj, visited, pathVisited) == true)
                    return true;
            } 
            // if the node is already visited, then it must be in the same path
            else if (pathVisited[neighbour] == true) {
                return true;
            }
        }
        // If we do not find cycle in the path for a node, we mark it as false.
        pathVisited[node] = false;
        return false;
    }

    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (checkCycle(i, adj, visited, pathVisited) == true) {
                    return true;
                }
            }
        }
        return false;
    }
}
