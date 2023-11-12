package Trees.BinaryTree.Basics;

import java.util.LinkedList;
import java.util.Queue;

public class DeleteNodeInBT {
    public Node deletionBT(Node root, int key) {
        // Write your code here and return the root of the changed tree
        if (root == null)
            return null;
        if (root.left == null && root.right == null) {
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node curr = null;
        Node delNode = null;
        Node lastParent = null;

        // Level order Traversal

        while (q.size() > 0) {
            curr = q.poll();
            if (curr.data == key) {
                delNode = curr;
            }
            if (curr.left != null) {
                lastParent = curr;
                q.add(curr.left);

            }
            if (curr.right != null) {
                lastParent = curr;
                q.add(curr.right);

            }
        }
        // Here curr is the Deepest Node and lastParent is the Parent Node of Curr /
        // DeepestNode
        if (delNode != null) {
            delNode.data = curr.data;
            if (lastParent.right == curr)
                lastParent.right = null;
            else
                lastParent.left = null;
        }
        return root;
    }
}
