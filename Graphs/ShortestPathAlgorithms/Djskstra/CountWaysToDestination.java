package Graphs.ShortestPathAlgorithms.Djskstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/

class Pair {
    int node;
    long distance;

    Pair(int node, long distance) {
        this.node = node;
        this.distance = distance;
    }
}

public class CountWaysToDestination {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());
        for (int i = 0; i < roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            long wt = roads[i][2];
            adjList.get(u).add(new Pair(v, wt));
            adjList.get(v).add(new Pair(u, wt));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> (int) (x.distance - y.distance));
        // Priority Queue Internal Comparator only Returns int, For Data Types other
        // than Int We had to Cast
        // This can also be Written as
        /*
         * PriorityQueue<Pair> pq = new PriorityQueue<>((n1,n2)->{
         * long w1 = n1.distance;
         * long w2 = n2.distance;
         * if(w1 == w2) return 0;
         * else if(w1 > w2) return 1;
         * else return -1;
         * });
         */
        long[] dist = new long[n];
        int[] ways = new int[n]; // Default Value is 0
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0, 0));
        int mod = (int) (1e9 + 7);

        while (pq.size() > 0) {
            Pair curr = pq.poll();
            long distance = curr.distance;
            int node = curr.node;

            for (Pair it : adjList.get(node)) {
                int adjNode = it.node;
                long edgeWt = it.distance;

                if (distance + edgeWt < dist[adjNode]) {
                    dist[adjNode] = distance + edgeWt;
                    pq.add(new Pair(adjNode, dist[adjNode]));
                    ways[adjNode] = ways[node];
                } else if (distance + edgeWt == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        return ways[n - 1] % mod;
    }
}
