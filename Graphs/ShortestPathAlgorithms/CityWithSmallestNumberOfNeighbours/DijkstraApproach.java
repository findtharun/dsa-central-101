package CityWithSmallestNumberOfNeighbours;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Pair {
    int node;
    int dis;

    Pair(int node, int dis) {
        this.node = node;
        this.dis = dis;
    }
}

public class DijkstraApproach {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(new Pair(edge[1], edge[2]));
            adjList.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.dis - y.dis);
        int city = 0;
        int cntmax = n;

        for (int i = 0; i < n; i++) {
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            pq.add(new Pair(i, 0));
            dist[i] = 0;

            while (!pq.isEmpty()) {
                Pair curnode = pq.poll();
                int getval = curnode.node;
                int getdis = curnode.dis;
                for (Pair neighbour : adjList.get(getval)) {
                    int newdis = getdis + neighbour.dis;
                    if (newdis <= distanceThreshold && newdis < dist[neighbour.node]) {
                        pq.add(new Pair(neighbour.node, newdis));
                        dist[neighbour.node] = newdis;
                    }
                }
            }

            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (dist[j] != Integer.MAX_VALUE) {
                    cnt++;
                }
            }
            if (cnt <= cntmax) // We Always need Less count
            {
                city = Math.max(city, i);
                cntmax = cnt;
            }
        }

        return city;
    }
}
