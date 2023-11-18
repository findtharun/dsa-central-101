package Trees.BST;

public class BSTFromPreorder {
    static int index;

    public TreeNode bstFromPreorder(int[] preorder) {
        index = 0;
        return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode helper(int[] preorder, int lowerBound, int upperBound) {
        if (index >= preorder.length || preorder[index] > upperBound
                || preorder[index] < lowerBound)
            return null;
        TreeNode root = new TreeNode(preorder[index++]);
        root.left = helper(preorder, lowerBound, root.data);
        root.right = helper(preorder, root.data, upperBound);
        return root;
    }
}
