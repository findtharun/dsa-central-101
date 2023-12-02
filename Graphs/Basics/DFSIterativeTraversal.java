package Graphs.Basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Iterator;

public class DFSIterativeTraversal {
    public ArrayList<Integer> iterativeDfsOfGraph(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            if (!visited[curr]) {
                visited[curr] = true;
                res.add(curr);
                Iterator<Integer> it = adj.get(curr).listIterator();
                while (it.hasNext()) {
                    int neighbour = it.next();
                    if (!visited[neighbour]) {
                        stack.push(neighbour);
                    }
                }
            }
        }
        return res;
    }
}
