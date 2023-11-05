package Trees.BinaryTree.Basics;

import java.util.*;

import javax.swing.tree.TreeNode;

// NOTE: All the Approaches have Space and Time Complexity as O(N)

public class HeightOfTree {

    public static int bfsTravseral(Node root) {
        int height = 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (q.size() > 0) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                Node curr = q.poll();
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
            height++;
        }
        return height;
    }

    public int recursiveDFS(Node root) {
        if (root == null)
            return 0;
        return 1 + Math.max(recursiveDFS(root.left), recursiveDFS(root.right));
    }

    public int iterativeDFS(Node root) {
        if (root == null)
            return 0;
        int finalDepth = 0;
        Stack<Node> treeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();

        // Init the Stack with root node with a depth of 1
        treeStack.push(root);
        depthStack.push(1);
        finalDepth = 1;
        while (!treeStack.isEmpty()) {
            Node subTree = treeStack.pop();
            int currentDepth = depthStack.pop();
            if (subTree.left == null && subTree.right == null) {
                finalDepth = Math.max(currentDepth, finalDepth);
            }
            if (subTree.right != null) {
                treeStack.push(subTree.right);
                depthStack.push(currentDepth + 1);
            }
            if (subTree.left != null) {
                treeStack.push(subTree.left);
                depthStack.push(currentDepth + 1);
            }
        }
        return finalDepth;
    }
}
