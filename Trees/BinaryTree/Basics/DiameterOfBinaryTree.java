package Trees.BinaryTree.Basics;

import java.util.HashMap;
import java.util.Stack;

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(Node root) {
        HashMap<Node, Integer> map = new HashMap<>();
        Stack<Node> st = new Stack<>();
        if (root != null)
            st.push(root);
        int diameter = 0;
        while (!st.isEmpty()) {
            Node curr = st.peek();
            if (curr.left != null && !map.containsKey(curr.left))
                st.push(curr.left);
            else if (curr.right != null && !map.containsKey(curr.right))
                st.push(curr.right);
            else {
                st.pop();
                int leftDepth = map.getOrDefault(curr.left, 0);
                int rightDepth = map.getOrDefault(curr.right, 0);
                // Calculating Height at Sub Tree and Putting in Map
                map.put(curr, 1 + Math.max(leftDepth, rightDepth));
                // Diameter Calculation
                diameter = Math.max(diameter, leftDepth + rightDepth);
            }
        }
        return diameter;
    }
}
