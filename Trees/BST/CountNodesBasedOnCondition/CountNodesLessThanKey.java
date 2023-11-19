package Trees.BST.CountNodesBasedOnCondition;

import Trees.BST.TreeNode;

public class CountNodesLessThanKey {
    public int BSTsmallcount(TreeNode root, int key) {
        if (root == null)
            return 0;
        if (root.data < key) // We may find some nodes in right as well
            return 1 + BSTsmallcount(root.left, key) + BSTsmallcount(root.right, key);
        else // we can only find in left sub tree
            return BSTsmallcount(root.left, key);
    }
}
