package Graphs.DetectCycle.UndirectedGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int node;
    int parent;

    public Pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }

    public class BFSApproach {
        public boolean detectCycle(int src, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
            visited[src] = true;
            Queue<Pair> q = new LinkedList<Pair>();
            q.offer(new Pair(src, -1));// Initial Node would be zero , Putting parent as -1

            while (q.size() > 0) {
                int node = q.peek().node;
                int parent = q.peek().parent;
                q.poll();
                for (int neighbour : adj.get(node)) {
                    if (!visited[neighbour]) {
                        visited[neighbour] = true;
                        q.offer(new Pair(neighbour, node)); // Node will be the parent for Its neighbours
                    } else if (neighbour != parent) { // If neighbour has already been visited and not a parent of node
                                                      // then Cycle found
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
            // Code here
            boolean[] visited = new boolean[V];
            for (int i = 0; i < V; i++) {
                if (!visited[i]) {
                    if (detectCycle(i, adj, visited))
                        return true;
                }
            }
            return false;
        }
    }
}