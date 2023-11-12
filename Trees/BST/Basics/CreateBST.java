package Trees.BST.Basics;

class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
    }

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

public class CreateBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        
        int mid = left + (right - left) / 2; // Calculate the middle index
        
        TreeNode root = new TreeNode(nums[mid]); // Create the root TreeNode
        
        // Recursively build the left and right subtrees
        root.left = sortedArrayToBST(nums, left, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, right);
        
        return root;
    }

    // Helper function to print the tree for testing
    private void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        printTree(root.left);
        System.out.print(root.data + " ");
        printTree(root.right);
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7};
        CreateBST converter = new CreateBST();
        TreeNode root = converter.sortedArrayToBST(sortedArray);
        converter.printTree(root); // In Order always gives the result in Sorted Order.
    }
}
