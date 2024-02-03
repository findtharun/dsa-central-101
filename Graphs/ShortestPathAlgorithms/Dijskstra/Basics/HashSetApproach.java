package Dijskstra.Basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Iterator;

class Pair {
    int node;
    int distance;

    Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;

    }

    @Override
    public boolean equals(Object o) {
        // For Adding Element to Set, It checks whether already existing or not , this
        // function should be implemented If we have custom Class
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Pair pair = (Pair) o;
        return distance == pair.distance && node == pair.node;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance, node);
    }
}

public class HashSetApproach {
    // from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // Sorts Nodes based on Smallest Distance in Ascending Order
        Set<Pair> st = new HashSet<>();
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);

        st.add(new Pair(S, 0)); // Distance from Source to Itself is 0;
        dist[S] = 0;

        while (st.size() > 0) {
            Iterator<Pair> iterator = st.iterator();
            Pair firstElement = new Pair(-1, -1);
            if (iterator.hasNext()) {
                firstElement = iterator.next(); // Smallest Distance
            }
            int curr_distance = firstElement.distance;
            int curr_node = firstElement.node;
            st.remove(firstElement);
            for (int i = 0; i < adj.get(curr_node).size(); i++) {
                int adjNode = adj.get(curr_node).get(i).get(0);
                int edgeWeight = adj.get(curr_node).get(i).get(1);
                if (curr_distance + edgeWeight < dist[adjNode]) {
                    if (dist[adjNode] != (int) 1e9)
                        st.remove(new Pair(adjNode,dist[adjNode])); // No Point in Having Distance More Path, Hence
                                                                     // Removing here.
                    dist[adjNode] = curr_distance + edgeWeight;
                    st.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        return dist;
    }
}
