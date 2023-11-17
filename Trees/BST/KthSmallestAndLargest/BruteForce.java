package Trees.BST.KthSmallestAndLargest;

import Trees.BST.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class BruteForce {
    List<Integer> res = new ArrayList<>();

    // If we do Inorder Traversal, It will always be sorted for BST. Hence we can
    // get kth smallest/ greatest from Array
    public int kthSmallest(TreeNode root, int k) {
        inOrderTraversal(root);
        return res.get(k - 1);
    }

 
    public void inOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        inOrderTraversal(root.left);
        res.add(root.data);
        inOrderTraversal(root.right);
    }

    // For Kth Largest Traversal is root.right, root.data;root.left
    public void inOrderTraversalLargest(TreeNode root) {
        if (root == null)
            return;
        inOrderTraversal(root.right);
        res.add(root.data);
        inOrderTraversal(root.left);
    }
}
