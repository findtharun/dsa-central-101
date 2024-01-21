package Graphs.ShortestPathAlgorithms.Djskstra.Basics;

import java.util.*;

class Pair {
    int distance;
    int node;

    Pair(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }
}

public class ShortestPath {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {

        // Creating Adjacency List
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        // Edges[][] contains node, neighbour and distance
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2])); // Undirected Graph
        }

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance); // Shortest Distance will
                                                                                             // be first
        int[] dist = new int[n];
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = (int) 1e9;
            parent[i] = i;
        }
        dist[0] = 0; // Source Node is 0
        pq.add(new Pair(0, 0));
        while (pq.size() > 0) {
            Pair curr = pq.poll();
            int distance = curr.distance;
            int node = curr.node;
            for (Pair iter : adj.get(node)) {
                int adjNode = iter.node;
                int edgeWeight = iter.distance;

                if (distance + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = distance + edgeWeight;
                    pq.add(new Pair(dist[adjNode], adjNode));
                    parent[adjNode] = node;

                }
            }
        }
        List<Integer> path = new ArrayList<>();
        if (dist[n - 1] == 1e9) { // If no Shortest path to End Exists
            path.add(-1);
            return path;
        }

        int node = n - 1; // Since it is the Destination
        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        return path;

    }
}
