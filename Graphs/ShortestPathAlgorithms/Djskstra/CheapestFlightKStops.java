package Graphs.ShortestPathAlgorithms.Djskstra;

import java.util.*;

class Tuple {
    int stops;
    int node;
    int cost;

    Tuple(int stops, int node, int cost) {
        this.stops = stops;
        this.node = node;
        this.cost = cost;
    }
}

class Pair {
    int node;
    int cost;

    Pair(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}
// Solution : https://takeuforward.org/data-structure/g-38-cheapest-flights-within-k-stops/

public class CheapestFlightKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Creating Adjacency List
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<Pair>());
        }
        int rowLen = flights.length;
        for(int i = 0; i<rowLen; i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }

        Queue<Tuple> q = new LinkedList<>();
        // Having Priority Queue would stop us from getting Optimal Value, Hence using Queue
        q.add(new Tuple(0,src,0));
        int[] dist = new int[n];
        for(int i=0;i<n;i++) dist[i] = (int)1e9;
        dist[src] = 0;
        while(q.size()>0){
            Tuple curr = q.poll();
            int stops = curr.stops;
            int node = curr.node;
            int cost = curr.cost;

            if(stops>k) continue;//We stop the process as soon as the limit for the stops reaches.
            for(Pair neighbours : adj.get(node)){
                  int adjNode = neighbours.node;
                  int adjCost = neighbours.cost;

                  if(adjCost + cost < dist[adjNode]){
                      dist[adjNode] = cost+adjCost;
                      q.add(new Tuple(stops+1,adjNode,dist[adjNode]));
                  }
            }
        }
        if(dist[dst] == 1e9) return -1;
        else return dist[dst];
    }
}
