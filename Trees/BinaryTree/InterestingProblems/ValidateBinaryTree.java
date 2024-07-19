package Trees.BinaryTree.InterestingProblems;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
// https://leetcode.com/problems/validate-binary-tree-nodes/description/
public class ValidateBinaryTree {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] parents = new int[n];
        Arrays.fill(parents, -1);
        // Step 1: Assign parents and check for invalid parent-child relationships
        for (int i = 0; i < n; i++) {
            int left = leftChild[i];
            int right = rightChild[i];

            if (left != -1) {
                if (parents[left] != -1) {
                    return false; // Left child already has a parent
                }
                parents[left] = i;
            }

            if (right != -1) {
                if (parents[right] != -1) {
                    return false; // Right child already has a parent
                }
                parents[right] = i;
            }
        }

        // Step 2: Find the root node
        int rootCount = 0;
        int rootNode = -1;
        for (int i = 0; i < n; i++) {
            if (parents[i] == -1) {
                rootCount++;
                rootNode = i;
                if (rootCount > 1) {
                    return false; // More than one root found
                }
            }
        }

        // Ensure there is exactly one root
        if (rootCount != 1) {
            return false;
        }

        // Step 3: Check for connected components using BFS or DFS
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(rootNode);
        visited[rootNode] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (leftChild[node] != -1 && !visited[leftChild[node]]) {
                queue.offer(leftChild[node]);
                visited[leftChild[node]] = true;
            }
            if (rightChild[node] != -1 && !visited[rightChild[node]]) {
                queue.offer(rightChild[node]);
                visited[rightChild[node]] = true;
            }
        }

        // Ensure all nodes are visited
        for (boolean isVisited : visited) {
            if (!isVisited) {
                return false;
            }
        }

        return true;
    }
}
