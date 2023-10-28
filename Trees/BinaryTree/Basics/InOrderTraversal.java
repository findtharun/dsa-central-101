package Trees.BinaryTree.Basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

public class InOrderTraversal {
    static List<Integer> inOrder = new ArrayList<>();

    public static void travsereRecursive(Node root) {
        if (root == null)
            return;

        travsereRecursive(root.left);
        inOrder.add(root.data);
        travsereRecursive(root.right);
    }

    public static List<Integer> inOrderTraversalRecursive(Node root) {
        travsereRecursive(root);
        return inOrder;

    }

    public static List<Integer> inorderTraversal(Node root) {
        Stack<Node> st = new Stack<>();
        while(true){
           if(root!=null){
               st.push(root);
               root = root.left;
           }else{
               if(st.isEmpty()) break;
               root = st.pop();
               inOrder.add(root.data);
               root = root.right;
           }
        }
        return inOrder;
    }
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 6, 6, 6 };
        // Node root = insertLevelOrderRecursive(arr, 0);
        Node root = CreateBinaryTree.insertLevelOrder(arr);
        // List<Integer> ans = inOrderTraversalRecursive(root);
        List<Integer> ans = inorderTraversal(root);
        System.out.println("Post Order Traversal");
        // List<Integer> ans = preOrderTraversalRecursive(root);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }

    }
}
