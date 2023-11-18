package Trees.BST;

public class BSTFromPostOrder {
    static int index;

    public TreeNode bstFromPostorder(int[] postorder) {
        index = postorder.length - 1;
        return helper(postorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode helper(int[] postorder, int lowerBound, int upperBound) {
        if (index < 0 || postorder[index] > upperBound
                || postorder[index] < lowerBound)
            return null;
        TreeNode root = new TreeNode(postorder[index--]);
        root.right = helper(postorder, root.data, upperBound);
        root.left = helper(postorder, lowerBound, root.data);
        return root;
    }
}
