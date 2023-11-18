package Trees.BinaryTree;

import java.util.HashMap;

public class ConstructTreeFromPreInOrder {
    private int preorderIdx = 0;

    public Node buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return construct(preorder, 0, inorder.length - 1, map);
    }

    public Node construct(int[] preorder, int left, int right, HashMap<Integer, Integer> map) {
        if (left > right)
            return null;
        int pval = preorder[preorderIdx];
        int inorderIdx = map.get(pval);

        Node root = new Node(pval);
        preorderIdx++;
        root.left = construct(preorder, left, inorderIdx - 1, map);
        root.right = construct(preorder, inorderIdx + 1, right, map);
        return root;
    }
}
