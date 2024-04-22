package Dijskstra;

// https://leetcode.com/problems/find-edges-in-shortest-paths/
import java.util.*;

class Pair {
    int node;
    int distance;

    Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

public class FindEdgesinShortestPaths {
    public boolean[] findAnswer(int n, int[][] edges) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        // Edges[][] contains node, neighbour and distance
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            graph.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2])); // Undirected Graph
        }

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance); // Shortest Distance will
                                                                                             // be first
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0; // Source Node is 0
        pq.add(new Pair(0, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int currDistance = curr.distance;
            int currNode = curr.node;
            if ((dist[currNode] != Integer.MAX_VALUE) && (currDistance > dist[currNode]))
                continue;
            for (Pair neighbor : graph.get(currNode)) {
                int adjNode = neighbor.node;
                int edgeWeight = neighbor.distance;

                if (currDistance + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = currDistance + edgeWeight;
                    pq.add(new Pair(adjNode, dist[adjNode]));
                }
            }
        }

        Set<String> shortestPathEdges = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n - 1);
        // BackTracking from Destination
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (Pair neighbor : graph.get(currentNode)) {
                // Finding whether this edge is in Shortest Path
                if (dist[currentNode] - neighbor.distance == dist[neighbor.node]) {
                    String edge = neighbor.node + ":" + currentNode;
                    shortestPathEdges.add(edge);
                    queue.add(neighbor.node);
                }
            }
        }
        boolean[] answer = new boolean[edges.length];
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            String edgeForward = edge[0] + ":" + edge[1];
            String edgeBackward = edge[1] + ":" + edge[0];
            if (shortestPathEdges.contains(edgeForward) || shortestPathEdges.contains(edgeBackward)) {
                answer[i] = true;
            }
        }
        return answer;
    }
}
