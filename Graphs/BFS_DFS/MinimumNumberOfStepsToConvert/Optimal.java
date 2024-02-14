package Graphs.BFS_DFS.MinimumNumberOfStepsToConvert;

public class Optimal {
    static int minOperations(int x, int y) {

        // If both are equal then return 0
        if (x == y)
            return 0;

        // Check if conversion is possible or not
        if (x <= 0 && y > 0)
            return -1;

        // If x > y then we can just increase y by 1
        // Therefore return the number of increments
        // required
        if (x > y)
            return x - y;

        // If odd,then increment y so that we can make it even, as If we Compare with BFS
        // approach Path, We clearly understand that since we are reverse engineering,
        // converting to Even is must
        if (y % 2 != 0)
            return 1 + minOperations(x, y + 1);

        // If y is even then divide it by 2 to make it
        // closer to x
        else
            return 1 + minOperations(x, y / 2);
    }

    public static void main(String[] args) {
        System.out.println(minOperations(4, 7));
    }
}
