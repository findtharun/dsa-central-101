package Graphs.TopologicalSort;

import java.util.ArrayList;
import java.util.Stack;

public class DFSTopologicalSort {
    static void dfs(int node, Stack<Integer> stack, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;
        for (int neighbour : adj.get(node)) {
            if (visited[neighbour] == false)
                dfs(neighbour, stack, visited, adj);
        }
        stack.push(node);
    }

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // add your code here
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[V];
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                dfs(i, stack, visited, adj);
            }
        }
        int j = 0;
        while (!stack.isEmpty()) {
            ans[j++] = stack.peek();
            stack.pop();
        }
        return ans;
    }
}
