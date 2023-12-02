package Graphs.Basics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DFSTraversal {

    public void dfsHelper(int node, List<List<Integer>> adj, boolean[] visited, ArrayList<Integer> res) {
        visited[node] = true;
        res.add(node);

        Iterator<Integer> it = adj.get(node).listIterator();
        while (it.hasNext()) {
            int neighbour = it.next();
            if (!visited[neighbour])
                dfsHelper(neighbour, adj, visited, res);
        }

    }

    public ArrayList<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        ArrayList<Integer> res = new ArrayList<Integer>();
        dfsHelper(0, adj, visited, res);
        return res;
    }
}
