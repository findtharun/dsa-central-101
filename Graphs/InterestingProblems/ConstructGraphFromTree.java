package Graphs.InterestingProblems;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class ConstructGraphFromTree {
    public void treeToGraph(TreeNode root) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        // Note : We are constructing Undirected Graph
        traverseTree(root, null, graph);
        for (TreeNode key : graph.keySet()) {
            System.out.println(key.val);
            List<TreeNode> currList = graph.get(key);
            for (TreeNode ele : currList) {
                System.out.print(ele.val + " ");
            }
            System.out.println("");
        }
    }

    public void traverseTree(
            TreeNode currNode,
            TreeNode prevNode,
            Map<TreeNode, List<TreeNode>> graph) {
        if (currNode == null) {
            return;
        }
        if (prevNode != null) {
            graph.computeIfAbsent(prevNode, k -> new ArrayList<TreeNode>());
            graph.get(prevNode).add(currNode);
            graph.computeIfAbsent(currNode, k -> new ArrayList<TreeNode>());
            graph.get(currNode).add(prevNode);
        }
        traverseTree(currNode.left, currNode, graph);
        traverseTree(currNode.right, currNode, graph);
    }
}
