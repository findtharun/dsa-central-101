package Trees.BinaryTree.BFS_DFS_Traversal;

import java.util.LinkedList;
import java.util.Queue;
import Trees.BinaryTree.Node;

// https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/description/
public class BFSTraversal {
    int finddata(Node node) {
        return node == null ? 0 : node.data;
    }

    public int sumEvenGrandparent(Node root) {
        Queue<Node> q = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        q.add(root);
        int sum = 0;
        while (!q.isEmpty()) {
            Node curr = q.poll();
            int currdata = curr.data;
            if ((currdata & 1) == 0) {
                if (curr.left != null) {
                    sum += finddata(curr.left.left) + finddata(curr.left.right);
                }
                if (curr.right != null) {
                    sum += finddata(curr.right.left) + finddata(curr.right.right);
                }
            }
            // Add the non-null child of the current node.
            if (curr.left != null)
                q.add(curr.left);
            if (curr.right != null)
                q.add(curr.right);
        }
        return sum;
    }
}
