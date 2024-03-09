package Recursion_Backtracking.BackTracking;

public class MColoringNodes {
    boolean isSafe(int node, boolean graph[][], int color[], int c, int n) {
        for (int i = 0; i < n; i++)
            if (graph[node][i] == true && c == color[i])
                return false; // If Connected Node has Same Color

        // returning true if no connected node has same colour.
        return true;
    }

    boolean graphColoringUtil(boolean graph[][], int m, int color[], int node, int n) {
        // if all vertices have been assigned colour then we return true.
        if (node == n)
            return true;

        for (int c = 1; c <= m; c++) {
            // checking if this colour can be given to a particular node.
            if (isSafe(node, graph, color, c, n)) {
                // assigning colour to the node.
                color[node] = c;

                // calling function recursively and checking if other nodes can be assigned other colours.
                if (graphColoringUtil(graph, m, color, node + 1, n) == true)
                    // returning true if the current allocation was successful.
                    return true;

                // if not true, we backtrack and remove the colour for that node
                color[node] = 0;
            }
        }
        // if no colour can be assigned, we return false.
        return false;
    }

    // Function to determine if graph can be coloured with at most M that no two adjacent vertices of graph are coloured with same colour.
    boolean graphColoring(boolean graph[][], int m, int n) {
        int color[] = new int[n];
        // checking if colours can be assigned.
        if (graphColoringUtil(graph, m, color, 0, n) == false) {
            return false;
        }

        return true;
    }
}
