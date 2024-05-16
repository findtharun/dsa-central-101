package Trees.BinaryTree.Basics;

// This questions is very useful in understanding recursion in Trees : https://leetcode.com/problems/evaluate-boolean-binary-tree/
public class EvaluateBinaryTree {
    public boolean evaluateTree(Node root) {
        if (root.data == 1)
            return true;
        if (root.data == 0)
            return false;
        if (root.data == 2)
            return evaluateTree(root.left) || evaluateTree(root.right);
        return evaluateTree(root.left) && evaluateTree(root.right);
    }
}
