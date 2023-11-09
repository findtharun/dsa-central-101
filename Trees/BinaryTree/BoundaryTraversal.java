package Trees.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryTraversal {
    public static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    public static void leftBoundaryTravserse(Node root, List<Integer> res) {
        Node curr = root.left;
        while (curr != null) {
            if (isLeaf(curr) == false)
                res.add(curr.data);
            if (curr.left != null)
                curr = curr.left;
            else
                curr = curr.right;
        }
    }

    public static void leafTraverse(Node root, List<Integer> res) {
        if (isLeaf(root) == true) {
            res.add(root.data);
            return;
        }
        // Pre Order Traversal
        if (root.left != null)
            leafTraverse(root.left, res);
        if (root.right != null)
            leafTraverse(root.right, res);
    }

    public static void rightBoundaryTraverse(Node root, List<Integer> res) {
        Stack<Integer> stack = new Stack<>();
        Node curr = root.right;
        while (curr != null) {
            if (isLeaf(curr) == false)
                stack.push(curr.data);
            if (curr.right != null)
                curr = curr.right;
            else
                curr = curr.left;
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
    }

    public static List<Integer> traverseBoundary(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        if (isLeaf(root) == false)
            res.add(root.data);
        leftBoundaryTravserse(root, res);
        leafTraverse(root, res);
        rightBoundaryTraverse(root, res);
        return res;
    }
}
