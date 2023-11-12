package Trees.BST.Basics;

public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val == key) {
            return deleteIt(root);
        }
        TreeNode dummy = root;
        while (root != null) {
            if (root.val > key) {
                if (root.left != null && root.left.val == key) {
                    root.left = deleteIt(root.left);
                    break;
                } else
                    root = root.left;
            } else {
                if (root.right != null && root.right.val == key) {
                    root.right = deleteIt(root.right);
                    break;
                } else
                    root = root.right;
            }
        }
        return dummy;
    }

    public TreeNode deleteIt(TreeNode root) {
        if (root.left == null)
            return root.right;
        if (root.right == null)
            return root.left;
        else {
            TreeNode rightChild = root.right;
            TreeNode lastRightNode = findRightLeaf(root.left);
            lastRightNode.right = rightChild;
            return root.left;
        }
    }

    public TreeNode findRightLeaf(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }
}
