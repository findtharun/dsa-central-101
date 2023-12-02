package Graphs.Basics;

public class CreateGraph {
    public static void main(String[] args) {
        // GraphUsingAdjList g = new GraphUsingAdjList(4);
        GraphUsingAdjMatrix g = new GraphUsingAdjMatrix(4);
        g.addEdge(0, 3, true);
        g.addEdge(1, 2, true);
        g.addEdge(1, 3, true);
        g.addEdge(2, 3, true);
        System.out.println(g);
    }
}
