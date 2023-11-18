package Trees.BinaryTree;

import java.util.HashMap;

public class ConstructTreeFromPostInOrder {
    static int postorderIdx;

    public Node buildTree(int[] inorder, int[] postorder) {
        postorderIdx = postorder.length - 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return helper(postorder, 0, postorder.length - 1, map);
    }

    public Node helper(int[] postorder, int left, int right, HashMap<Integer, Integer> map) {
        if (left > right)
            return null;
        int pval = postorder[postorderIdx--];
        int inorderIdx = map.get(pval);

        Node root = new Node(pval);
        root.right = helper(postorder, inorderIdx + 1, right, map);
        root.left = helper(postorder, left, inorderIdx - 1, map);
        return root;

    }
}
