package Graphs.Basics;

public class CreateGraph {
    public static void main(String[] args) {
        int V = 4;
        GraphUsingAdjList g = new GraphUsingAdjList(V);
        // GraphUsingAdjMatrix g = new GraphUsingAdjMatrix(4);
        g.addEdge(0, 3, true);
        g.addEdge(1, 2, true);
        g.addEdge(1, 3, true);
        g.addEdge(2, 3, true);
        System.out.println(g);
        BFSTraversal obj = new BFSTraversal();
        System.out.println(obj.bfsOfGraph(V, g.adjList));
    }
}
