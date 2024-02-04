/* 
 * Shortest distances between every pair of vertices in a given edge-weighted directed graph
 * Time Complexity: O(V^3)
 * https://takeuforward.org/data-structure/floyd-warshall-algorithm-g-42/
 */

public class FloydWarshallAlgorithm {
    public void shortest_distance(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = (int) (1e9);
                }
                if (i == j)
                    matrix[i][j] = 0;
            }
        }
        for (int k = 0; k < n; k++) { // We reach nodes via every other node
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        /* 
            To Handle Negative Cycle
        for(int i = 0;i<n; i++){
            if(matrix[i][i] <0) {
                
            }
        } */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1e9) {
                    matrix[i][j] = -1; // The Node can not be Reached
                }
            }
        }
    }
}
