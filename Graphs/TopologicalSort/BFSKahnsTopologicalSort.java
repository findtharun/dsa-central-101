package Graphs.TopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// We Track Inorder of Each Node, Start BFS Traversal from Nodes having 0  Indegree, Decrease Associated Node Indegree by 1
// We add to Result once Indegree is 0 (It means all dependencies are Completed)
public class BFSKahnsTopologicalSort {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int neighbour : adj.get(i)) {
                inDegree[neighbour]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] topologicalOrder = new int[V];
        int j = 0;
        while (q.size() > 0) {
            int curr_node = q.peek();
            q.poll();
            topologicalOrder[j++] = curr_node;

            for (int outgoingNode : adj.get(curr_node)) {
                inDegree[outgoingNode]--;
                if (inDegree[outgoingNode] == 0) {
                    q.offer(outgoingNode);
                }
            }
        }
        return topologicalOrder;
    }
}
