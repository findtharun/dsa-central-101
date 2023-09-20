package StackAndQueue.Celebrity;

public class BruteForce {
    int celebrity(int M[][], int n) {
        int celebrity = -1;
        for (int i = 0; i < n; i++) {
            Boolean knowsAny = false;
            Boolean knownToAll = true;
            for (int j = i; j < n; j++) {
                if (M[i][j] == 1) {
                    knowsAny = true;
                    break;
                }
            }

            for (int j = 0; j < n; j++) {
                if (M[j][i] == 0 && i != j) {
                    knownToAll = false;
                    break;
                }
            }
            if (knownToAll && !knowsAny) {
                celebrity = i;
                break;
            }
        }
        return celebrity;
    }
}
