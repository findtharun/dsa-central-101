package Graphs.DetectCycle.DirectedGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KahnBFS {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int neighbour : adj.get(i)) {
                inDegree[neighbour]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0)
                q.offer(i);
        }
        // Cycle Found as There are no Nodes with InDegree 0
        if (q.size() == 0)
            return true;
        List<Integer> topologicalOrder = new ArrayList<>();
        while (q.size() > 0) {
            int curr_node = q.peek();
            topologicalOrder.add(curr_node);
            q.poll();
            for (int outgoingNode : adj.get(curr_node)) {
                inDegree[outgoingNode]--;
                if (inDegree[outgoingNode] == 0)
                    q.offer(outgoingNode);
            }
        }
        if (topologicalOrder.size() != V)
            return true;
        return false;
    }
}
