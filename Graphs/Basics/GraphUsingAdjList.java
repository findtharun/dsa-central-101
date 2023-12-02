package Graphs.Basics;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class GraphUsingAdjList {
    int V; // No. of Vertices
    List<List<Integer>> adjList = new ArrayList<>();

    GraphUsingAdjList(int V) {
        this.V = V;
        for (int i = 0; i < V; i++) {
            adjList.add(new LinkedList<Integer>());
        }
    }

    void addEdge(int u, int v, boolean undirected) {
        adjList.get(u).add(v);
        if (undirected) {
            adjList.get(v).add(u);
        }
    }

    @Override
    public String toString() {
        return "Graph {" +
                "V=" + V +
                ", adjMatrix =" + adjList.toString() +
                '}';
    }
}
