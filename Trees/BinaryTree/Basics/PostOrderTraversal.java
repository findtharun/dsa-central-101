package Trees.BinaryTree.Basics;

import java.util.ArrayList;
import java.util.List;

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
    public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 5, 6, 6, 6, 6 };
    // Node root = insertLevelOrderRecursive(arr, 0);
    Node root = CreateBinaryTree.insertLevelOrder(arr);
    List<Integer> ans = postOrderTraversalRecursive(root);
    System.out.println("Post Order Traversal");
    // List<Integer> ans = preOrderTraversalRecursive(root);
    for (int i = 0; i < ans.size(); i++) {
      System.out.print(ans.get(i) + " ");
    }

  }
}
