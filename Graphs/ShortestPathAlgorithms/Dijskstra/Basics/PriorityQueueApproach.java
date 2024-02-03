package Dijskstra.Basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pair {
    int node;
    int distance;

    Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

// https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
public class PriorityQueueApproach {
    // from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // Sorts Nodes based on Smallest Distance in Ascending Order
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);

        pq.add(new Pair(0, S)); // Distance from Source to Itself is 0;
        dist[S] = 0;

        while (pq.size() > 0) {
            Pair curr = pq.poll();
            int curr_distance = curr.distance;
            int curr_node = curr.node;
            for (int i = 0; i < adj.get(curr_node).size(); i++) {
                int adjNode = adj.get(curr_node).get(i).get(0);
                int edgeWeight = adj.get(curr_node).get(i).get(1);
                if (curr_distance + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = curr_distance + edgeWeight;
                    pq.add(new Pair(adjNode, dist[adjNode]));
                }
            }
        }
        return dist;
    }
}
