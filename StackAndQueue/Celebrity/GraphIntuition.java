package StackAndQueue.Celebrity;

public class GraphIntuition {
    int celebrity(int M[][], int n) {
        int[] outdegree = new int[n];
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int isKnows = M[i][j];
                outdegree[i] += isKnows;
                indegree[j] += isKnows;
            }
        }
        for (int i = 0; i < n; i++) {
            if (outdegree[i] == 0 && indegree[i] == n - 1)
                return i;
            // Celebrity Should not Know Anyone, But Everyone Should know the Celebrity
        }
        return -1;
    }
}
