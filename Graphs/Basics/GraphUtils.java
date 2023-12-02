package Graphs.Basics;

import java.util.*;

public class GraphUtils {
    public static void main(String[] args) {
        int V = 6;
        GraphUsingAdjList g = new GraphUsingAdjList(V);
        // GraphUsingAdjMatrix g = new GraphUsingAdjMatrix(4);
        g.addEdge(0, 3, true);
        g.addEdge(0, 5, true);
        g.addEdge(1, 2, true);
        g.addEdge(1, 3, true);
        g.addEdge(2, 3, true);
        g.addEdge(1, 4, true);
        System.out.println(g);
        BFSTraversal bfsObj = new BFSTraversal();
        DFSTraversal dfsObj = new DFSTraversal();
        DFSIterativeTraversal dfsIterObj = new DFSIterativeTraversal();
        // ArrayList<Integer> bfsRes = bfsObj.bfsOfGraph(V, g.adjList);
        // System.out.println("BFS Traversal: " + bfsRes);
        ArrayList<Integer> dfsRes = dfsObj.dfsOfGraph(V, g.adjList);
        System.out.println("DFS Traversal: " + dfsRes);
        ArrayList<Integer> dfsIterRes = dfsIterObj.iterativeDfsOfGraph(V, g.adjList);
        System.out.println("DFS Iterative Traversal: " + dfsIterRes);
    }
}
