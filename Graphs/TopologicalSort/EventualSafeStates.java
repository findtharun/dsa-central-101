package Graphs.TopologicalSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            adjRev.add(new ArrayList<>());
        }
        int[] indegree = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            // i -> it ; We need to reverse to : it -> i
            for (int it : graph[i]) {
                adjRev.get(it).add(i);
                indegree[i]++;
            }
        }
        // All Nodes having Indegree 0 are Terminal Nodes
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        // All Nodes which can be reached to Terminal Nodes are Safe, Hence We are
        // Traversing reversely from Terminal Nodes
        List<Integer> safeNode = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            safeNode.add(node);
            for (int it : adjRev.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0)
                    q.add(it);
            }
        }
        Collections.sort(safeNode);
        return safeNode;
    }
}
