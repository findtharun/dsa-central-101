package Trees.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class StructuralIlyIdentical {
    public boolean areIdenticalTrees(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;

        if (areIdenticalTrees(root1.left, root2.left) == false || areIdenticalTrees(root1.right, root2.right) == false)
            return false;
        return true;
    }

    public boolean areIdenticalTreesIterative(Node root1, Node root2) {

        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }

        Queue<Node> tree1 = new LinkedList<Node>();
        Queue<Node> tree2 = new LinkedList<Node>();

        tree1.add(root1);
        tree2.add(root2);

        while (!tree1.isEmpty() && !tree2.isEmpty()) {
            Node currentNode1 = tree1.poll();
            Node currentNode2 = tree2.poll();
            if (currentNode1 == null && currentNode2 == null)
                continue;
            if (currentNode1 == null || currentNode2 == null)
                return false;
            tree1.add(currentNode1.left);
            tree1.add(currentNode1.right);
            tree2.add(currentNode2.left);
            tree2.add(currentNode2.right);
        }
        return tree1.isEmpty() && tree2.isEmpty();
    }
}
