package Trees.BinaryTree.BFS_DFS_Traversal;

import Trees.BinaryTree.Node;

// https://leetcode.com/problems/sum-of-nodes-with-even-dataued-grandparent/description/
public class DFSTraversal {
    int recur(Node node, int p, int gP) {
        if (node == null) {
            return 0;
        }
        int currValue = 0;
        if (gP % 2 == 0) {
            currValue += node.data;
        }
        return currValue + recur(node.left, node.data, p) + recur(node.right, node.data, p);
    }

    public int sumEvenGrandparent(Node root) {
        return recur(root, -1, -1);
    }
}
