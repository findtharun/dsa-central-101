package Arrays;

/**
 * For each cell x,y after is defined as
 * 
 * For I in range(x)
 * For j in range (y)
 * S = s+ before(i)(j)
 * After(x)(y) = s
 * 
 * Give me before matrix in java
 */
public class ArrayManipulation {
    public static void main(String[] args) {
        int[][] after = {
                { 1, 2 },
                { 3, 4 }
        };

        int[][] before = calculateBeforeMatrix(after);

        // Print the before matrix
        for (int i = 0; i < before.length; i++) {
            for (int j = 0; j < before[i].length; j++) {
                System.out.print(before[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] calculateBeforeMatrix(int[][] after) {
        int rows = after.length;
        int cols = after[0].length;
        int[][] before = new int[rows][cols];

        before[0][0] = after[0][0];

        // Fill the first row
        for (int j = 1; j < cols; j++) {
            before[0][j] = after[0][j] - after[0][j - 1];
        }

        // Fill the first column
        for (int i = 1; i < rows; i++) {
            before[i][0] = after[i][0] - after[i - 1][0];
        }

        // Fill the rest of the matrix
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                before[i][j] = after[i][j] - after[i - 1][j] - after[i][j - 1] + after[i - 1][j - 1];
            }
        }
        return before;
    }

}
