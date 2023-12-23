package Graphs.BiPartiteGraph;

public class DFS {
    // In Graph we can mark all nodes with 2 colors such that no adjacent will have same color.
    // If a Graph has a Cycle with Odd Number of Nodes - It can never be BiPartite.
    // Colors for Now are 0,1
    public boolean dfs(int node, int curr_color, int[] color, int[][] graph) {
        color[node] = curr_color;

        for (int neighbour : graph[node]) {
            if (color[neighbour] == -1) {
                if (dfs(neighbour, 1 - curr_color, color, graph) == false)
                    return false;
            } else if (curr_color == color[neighbour])
                return false;
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        for (int i = 0; i < V; i++)
            color[i] = -1;
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (dfs(i, 0, color, graph) == false)
                    return false;
            }
        }
        return true;
    }
}
