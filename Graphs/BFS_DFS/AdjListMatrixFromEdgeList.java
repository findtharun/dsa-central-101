package Graphs.BFS_DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

// Given a Edge List, Print Adjancy List and Adjaceny Matrix
public class AdjListMatrixFromEdgeList {
    public void printAdjacncyList(int V, int edges[][]) {
        List<List<Integer>> adjList = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        System.out.println(adjList);
    }

    public void printAdjancyMatrix(int V, int edges[][]) {
        int[][] adjMatrix = new int[V][V];
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjMatrix[u][v] = 1;
            adjMatrix[v][u] = 1;
        }
        System.out.println(Arrays.deepToString(adjMatrix));
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = { { 0, 1 }, { 0, 4 }, { 4, 1 }, { 4, 3 }, { 1, 3 }, { 1, 2 }, { 3, 2 } };
        AdjListMatrixFromEdgeList obj = new AdjListMatrixFromEdgeList();
        obj.printAdjancyMatrix(V, edges);
        obj.printAdjacncyList(V, edges);
    }
}
