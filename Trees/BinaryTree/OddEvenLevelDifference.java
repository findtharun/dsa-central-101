package Trees.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

// Asked in Amazon (https://www.geeksforgeeks.org/difference-between-sums-of-odd-and-even-levels/)
public class OddEvenLevelDifference {
    int getLevelDiff(Node node) {
        // Base case
        if (node == null)
            return 0;

        // Difference for root is root's data - difference for
        // left subtree - difference for right subtree
        return node.data - getLevelDiff(node.left) -
                getLevelDiff(node.right);
    }

    int evenOddLevelDifference(Node root) {
        if (root == null)
            return 0;

        // create a queue for
        // level order traversal
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int level = 0;
        int evenSum = 0, oddSum = 0;

        // traverse until the
        // queue is empty
        while (q.size() != 0) {
            int size = q.size();
            level++;

            // traverse for complete level
            while (size > 0) {
                Node temp = q.remove();
                if (level % 2 == 0) evenSum += temp.data;
                else oddSum += temp.data;

                // check for left child
                if (temp.left != null) q.add(temp.left);

                // check for right child
                if (temp.right != null) q.add(temp.right);
                
                size--;
            }
        }
        return (oddSum - evenSum);
    }

}
