package Trees.BinaryTree.Basics;

import java.util.*;

//BFS
public class LevelOrderTraversal {
    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> Tree = new ArrayList<>();
        if (root == null)
            return Tree;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (q.size() > 0) {
            int levelSize = q.size();
            List<Integer> subTree = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                Node curr = q.poll();
                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);
                subTree.add(curr.data);
            }
            Tree.add(subTree);
        }
        return Tree;
    }
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 6, 6, 6 };
        // Node root = insertLevelOrderRecursive(arr, 0);
        Node root = CreateBinaryTree.insertLevelOrder(arr);
        // List<Integer> ans = postOrderTraversalRecursive(root);
        List<List<Integer>> ans = levelOrder(root);
        System.out.println("Level Order Traversal");
        // List<Integer> ans = preOrderTraversalRecursive(root);
        System.out.print("[");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("[");
           for(int j=0;j<ans.get(i).size();j++){
                System.out.print(ans.get(i).get(j)+",");
           }
           System.out.print("]");
        }
        System.out.print("[");
    }
}
