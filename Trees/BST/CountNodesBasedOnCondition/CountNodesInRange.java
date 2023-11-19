package Trees.BST.CountNodesBasedOnCondition;

import Trees.BST.TreeNode;

public class CountNodesInRange {
    static int count = 0;

    int range(TreeNode root, int min, int max) {
        if (root == null)
            return 0;
        if (min <= root.data && max > root.data)
            count = count + 1;
        if (min <= root.data)
            count = count + range(root.left, min, max);
        if (max > root.data)
            count = count + range(root.right, min, max);
        return count;
    }
}
