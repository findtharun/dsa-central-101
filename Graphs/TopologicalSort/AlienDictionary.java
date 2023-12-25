package Graphs.TopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionary {
    public ArrayList<Integer> topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
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

        ArrayList<Integer> topologicalOrder = new ArrayList<>();
        while (q.size() > 0) {
            int curr_node = q.peek();
            topologicalOrder.add(curr_node);
            q.poll();

            for (int outgoingNode : adj.get(curr_node)) {
                inDegree[outgoingNode]--;
                if (inDegree[outgoingNode] == 0) {
                    q.offer(outgoingNode);
                }
            }
        }
        return topologicalOrder;
    }

    public String findOrder(String[] dict, int N, int K) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());
            for (int j = 0; j < len; j++) {
                // First Mismatched Character in S1 Comes before s2. Hence Make an Edge
                if (s1.charAt(j) != s2.charAt(j)) {
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }
        ArrayList<Integer> topologicalOrder = topoSort(K, adj);
        String ans = "";
        for (int it : topologicalOrder) {
            ans = ans + (char) (it + (int) ('a'));
        }
        return ans.length() == K ? ans : ""; // For Failing Cases return Empty (Ex : When Cycle Exists)
    }
}
