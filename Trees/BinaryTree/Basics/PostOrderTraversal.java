package Trees.BinaryTree.Basics;

import java.util.*;

public class PostOrderTraversal {

    static List<Integer> postOrder = new ArrayList<>();

    public static void travsereRecursive(Node root) {
        if (root == null)
            return;

        travsereRecursive(root.left);
        travsereRecursive(root.right);
        postOrder.add(root.data);
    }

    public static List<Integer> postOrderTraversalRecursive(Node root) {
        travsereRecursive(root);
        return postOrder;

    }

    public static List<Integer> postorderTraversal(Node root) {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(root);
        if (root == null)
            return postOrder;
        while (!s1.isEmpty()) {
            Node curr = s1.pop();
            s2.push(curr);
            if (curr.left != null)
                s1.push(curr.left);
            if (curr.right != null)
                s1.push(curr.right);
        }
        while (!s2.isEmpty()) {
            postOrder.add(s2.pop().data);
        }
        return postOrder;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 6, 6, 6 };
        // Node root = insertLevelOrderRecursive(arr, 0);
        Node root = CreateBinaryTree.insertLevelOrder(arr);
        // List<Integer> ans = postOrderTraversalRecursive(root);
        List<Integer> ans = postorderTraversal(root);
        System.out.println("Post Order Traversal");
        // List<Integer> ans = preOrderTraversalRecursive(root);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }

    }
}
