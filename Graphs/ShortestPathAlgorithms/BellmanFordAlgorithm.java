import java.util.ArrayList;
import java.util.Arrays;

/*
 * To Find Shortest Path from Source to every Node in Directed Graph.
 * Time Complexity: O(V*E) 
 * https://takeuforward.org/data-structure/bellman-ford-algorithm-g-41/
 * NOTE : For un Directed Graphs, Turn it to Directed First or Handle while calculating Distance
 */

public class BellmanFordAlgorithm {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] dist = new int[V];
        int[] temp = new int[1]; // For returing, when there are Negative Cycles
        Arrays.fill(dist, (int) 1e8);
        dist[S] = 0;
        // We may need not start S, We can start with any edge
        for (int i = 0; i < V - 1; i++) {
            for (ArrayList<Integer> it : edges) {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);

                if (dist[u] != 1e8 && dist[u] + wt < dist[v])
                    dist[v] = dist[u] + wt;
            }
        }
        // Nth relaxation to check negative cycle
        for (ArrayList<Integer> it : edges) {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);
            if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                temp[0] = -1;
                return temp;
            }
        }
        return dist;
    }
}
