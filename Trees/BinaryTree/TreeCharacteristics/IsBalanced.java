package Trees.BinaryTree.TreeCharacteristics;

import Trees.BinaryTree.Node;

public class IsBalanced {
    private boolean ans = true;

    public int height(Node root) {
        if (root == null)
            return 0;
        int l = height(root.left);
        int r = height(root.right);
        if (Math.abs(l - r) > 1) {
            ans = false;
        }
        return 1 + Math.max(l, r);
    }

    public boolean isBalanced(Node root) {
        if (root == null)
            return true;
        height(root);
        return ans;
    }
}
