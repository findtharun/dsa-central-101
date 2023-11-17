package Trees.BST.KthSmallestAndLargest;

import java.util.Stack;

import Trees.BST.TreeNode;

public class Optimal {
    public int kthSmallest(TreeNode root, int k) {
        int res = -1;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            k--;
            if (k == 0) {
                res = curr.data;
                break;
            }
            curr = curr.right;
        }
        return res;
    }

    public int kthLargest(TreeNode root, int k) {
        int res = -1;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.right;
            }
            curr = stack.pop();
            k--;
            if (k == 0) {
                res = curr.data;
                break;
            }
            curr = curr.left;
        }
        return res;
    }
}
