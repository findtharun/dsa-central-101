package Trees.BinaryTree.Basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {
  static List<Integer> preOrder = new ArrayList<>();

  public static List<Integer> preorderTraversal(Node root) {
    if (root == null)
      return preOrder;

    Stack<Node> st = new Stack<>();
    st.push(root);

    while (!st.isEmpty()) {
      Node cur = st.pop();
      preOrder.add(cur.data);

      if (cur.right != null)
        st.push(cur.right);
      if (cur.left != null)
        st.push(cur.left);
    }
    return preOrder;
  }

  public static void travsereRecursive(Node root) {
    if (root == null)
      return;
    preOrder.add(root.data);
    travsereRecursive(root.left);
    travsereRecursive(root.right);
  }

  public static List<Integer> preOrderTraversalRecursive(Node root) {
    travsereRecursive(root);
    return preOrder;

  }

  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 5, 6, 6, 6, 6 };
    // Node root = insertLevelOrderRecursive(arr, 0);
    Node root = CreateBinaryTree.insertLevelOrder(arr);
    List<Integer> ans = preorderTraversal(root);
    System.out.println("Pre Order Traversal");
    // List<Integer> ans = preOrderTraversalRecursive(root);
    for (int i = 0; i < ans.size(); i++) {
      System.out.print(ans.get(i) + " ");
    }

  }

}
