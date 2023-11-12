package Trees.BST.Basics;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public class InsertNodeToBST {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            TreeNode curr = root;
            if (root == null) {
                root = new TreeNode(val);
                return root;
            }
            while (true) {
                if (curr.val <= val) {
                    if (curr.right != null)
                        curr = curr.right;
                    else {
                        curr.right = new TreeNode(val);
                        break;
                    }
                } else {
                    if (curr.left != null)
                        curr = curr.left;
                    else {
                        curr.left = new TreeNode(val);
                        break;
                    }
                }
            }
            return root;
        }
    }

}