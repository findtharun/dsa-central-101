package Graphs.Basics;

import java.util.Arrays;

public class GraphUsingAdjMatrix {
    int V; // No .of Vertices
    int[][] adjMatrix;

    GraphUsingAdjMatrix(int V) {
        this.V = V;
        adjMatrix = new int[V][V];
    }

    void addEdge(int u, int v, boolean undirected) {
        adjMatrix[u][v] = 1;
        if (undirected)
            adjMatrix[v][u] = 1;
    }

    @Override
    public String toString() {
        return "Graph {" +
                "V=" + V +
                ", adjList =" + Arrays.deepToString(adjMatrix) +
                '}';
    }
}
