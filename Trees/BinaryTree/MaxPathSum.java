package Trees.BinaryTree;

public class MaxPathSum {
    public int maxPathDown(Node root, int[] maxdata) {
        if (root == null)
            return 0;
        // We are not Considering negative dataues, Inplace of negative it would be 0
        int leftSum = Math.max(0, maxPathDown(root.left, maxdata));
        int rightSum = Math.max(0, maxPathDown(root.right, maxdata));
        maxdata[0] = Math.max(maxdata[0], leftSum + rightSum + root.data);
        return Math.max(leftSum, rightSum) + root.data;
        // Since it is reccursive call, we return Max Path at that node

    }

    public int maxPathSum(Node root) {
        int[] maxdata = new int[1];// Since Java Does not allow pass by reference for Variables, We are storing in
                                   // array. Jave allows Pass By Reference for Objects.
        maxdata[0] = Integer.MIN_VALUE;
        maxPathDown(root, maxdata);
        return maxdata[0];
    }
}
