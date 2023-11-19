package Trees.BinaryTree;

import java.util.Stack;

public class HasPathSum {
    public boolean hasPathSumIterative(Node root, int targetSum) {
        if (root == null)
            return false;
        Stack<Node> path = new Stack<>();
        Stack<Integer> sumPath = new Stack<>();

        path.push(root);
        sumPath.push(root.data);

        while (!path.isEmpty()) {
            Node currNode = path.pop();
            int currVal = sumPath.pop();
            // If it is only Leaf node , Condition Satsifies
            if (currVal == targetSum && currNode.left == null && currNode.right == null)
                return true;

            if (currNode.left != null) {
                path.push(currNode.left);
                sumPath.push(currVal + currNode.left.data);
            }

            if (currNode.right != null) {
                path.push(currNode.right);
                sumPath.push(currVal + currNode.right.data);
            }
        }
        return false;
    }

    public boolean hasPathSum(Node root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return targetSum == root.data;
        }

        boolean leftSum = hasPathSum(root.left, targetSum - root.data);
        if (leftSum == true)
            return true;
        boolean rightSum = hasPathSum(root.right, targetSum - root.data);
        if (rightSum == true)
            return true;

        // return leftSum || rightSum;
        return false;
    }
}
