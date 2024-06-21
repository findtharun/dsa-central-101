// Count Distinct Elements in all Subtrees and Return Maximum Count 
// This was aksed in Google Telphone Interview

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class MaxDistinctCountInSubtrees {
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        // Get the distinct elements count for each subtree
        Map<TreeNode, Integer> distinctElementsMap = countDistinctElementsInSubtrees(root);

        // Find and print the highest distinct count
        int highestDistinctCount = getHighestDistinctCount(distinctElementsMap);
        System.out.println("Highest distinct count: " + highestDistinctCount);
    }

    // Method to count distinct elements in subtrees
    public static Map<TreeNode, Integer> countDistinctElementsInSubtrees(TreeNode root) {
        // Map to store the number of distinct elements for each subtree
        Map<TreeNode, Integer> distinctElementsMap = new HashMap<>();
        // Traverse the tree and fill the map
        traverseTree(root, distinctElementsMap);
        return distinctElementsMap;
    }

    // Helper method to traverse the tree and calculate distinct elements
    private static Set<Integer> traverseTree(TreeNode node, Map<TreeNode, Integer> distinctElementsMap) {
        if (node == null) {
            return new HashSet<>(); // Return an empty set for null nodes
        }

        // Recursively get the distinct elements from the left subtree
        Set<Integer> leftDistinctElements = traverseTree(node.left, distinctElementsMap);
        // Recursively get the distinct elements from the right subtree
        Set<Integer> rightDistinctElements = traverseTree(node.right, distinctElementsMap);

        // Combine the distinct elements from left and right subtrees
        Set<Integer> currentDistinctElements = new HashSet<>(leftDistinctElements);
        currentDistinctElements.addAll(rightDistinctElements);
        // Add the current node's value
        currentDistinctElements.add(node.val);

        // Store the count of distinct elements for the current node's subtree
        distinctElementsMap.put(node, currentDistinctElements.size());

        return currentDistinctElements;
    }

    // Method to get the highest distinct count from the map
    private static int getHighestDistinctCount(Map<TreeNode, Integer> map) {
        int maxDistinctCount = 0;
        for (int count : map.values()) {
            if (count > maxDistinctCount) {
                maxDistinctCount = count;
            }
        }
        return maxDistinctCount;
    }

}
