package Graphs.Basics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Iterator;

public class BFSTraversal {
    public ArrayList<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int curr = 0;
        visited[curr] = true;
        q.add(curr);
        while (q.size() > 0) {
            curr = q.poll();
            res.add(curr);

            Iterator<Integer> it = adj.get(curr).listIterator();
            while (it.hasNext()) {
                int toVisit = it.next();
                if (!visited[toVisit]) {
                    visited[toVisit] = true;
                    q.add(toVisit);
                }
            }
        }
        return res;
    }
}
