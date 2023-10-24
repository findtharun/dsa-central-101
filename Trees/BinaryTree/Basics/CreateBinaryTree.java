package Trees.BinaryTree.Basics;

import java.util.*;

public class CreateBinaryTree {
    public static Node insertLevelOrderRecursive(int[] arr, int i) {
        Node root = null;
        int n = arr.length;
        if (i < n) {
            root = new Node(arr[i]);
            root.left = insertLevelOrderRecursive(arr, 2 * i + 1);
            root.right = insertLevelOrderRecursive(arr, 2 * i + 2);
            i++;
        }
        return root;
    }

    public static Node insertLevelOrder(int[] arr) {
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(arr[0]);
        q.add(root);
        int i = 1;
        while (i < arr.length) {
            Node curr = q.poll();
            if (i < arr.length) {
                Node leftNode = new Node(arr[i++]);
                curr.left = leftNode;
                q.add(curr.left);
            }
            if (i < arr.length) {
                Node righNode = new Node(arr[i++]);
                curr.right = righNode;
                q.add(curr.right);
            }
        }

        return root;
    }

    // Function to print tree nodes in InOrder fashion
    public static void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 6, 6, 6 };
        // Node root = insertLevelOrderRecursive(arr, 0);
        Node root = insertLevelOrder(arr);
        inOrderTraversal(root);
    }
}
