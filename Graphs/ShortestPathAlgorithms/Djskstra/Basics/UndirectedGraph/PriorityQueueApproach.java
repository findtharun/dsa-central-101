package Graphs.ShortestPathAlgorithms.Djskstra.Basics.UndirectedGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pair {
    int distance;
    int node;

    Pair(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }
}
// https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
public class PriorityQueueApproach {
    // from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // Sorts Nodes based on Smallest Distance in Ascending Order
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);

        pq.add(new Pair(0, S)); // Distance from Source to Itself is 0;
        dist[0] = 0;

        while (pq.size() > 0) {
            int curr_distance = pq.peek().distance;
            int curr_node = pq.peek().node;
            pq.poll();

            for (int i = 0; i < adj.get(curr_node).size(); i++) {
                int adjNode = adj.get(curr_node).get(i).get(0);
                int edgeWeight = adj.get(curr_node).get(i).get(1);
                if (curr_distance + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = curr_distance + edgeWeight;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        return dist;
    }
}
