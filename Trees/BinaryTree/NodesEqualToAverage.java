package Trees.BinaryTree;

public class NodesEqualToAverage {
    int res = 0;

    public int averageOfSubtree(Node root) {
        dfs(root);
        return res;
    }

    public int[] dfs(Node node) {
        if (node == null)
            return new int[] { 0, 0 };

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int currSum = left[0] + right[0] + node.data;
        int currCount = left[1] + right[1] + 1;
        if (currSum / currCount == node.data)
            res++;
        return new int[] { currSum, currCount };
    }
}
