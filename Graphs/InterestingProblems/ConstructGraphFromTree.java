package Graphs.InterestingProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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

public class ConstructGraphFromTree {
    public void treeToGraph(TreeNode root) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        Set<TreeNode> leafNodes = new HashSet<>();

        traverseTree(root, null, graph, leafNodes);
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
            Map<TreeNode, List<TreeNode>> graph,
            Set<TreeNode> leafNodes) {
        if (currNode == null) {
            return;
        }
        if (currNode.left == null && currNode.right == null) {
            leafNodes.add(currNode);
        }
        if (prevNode != null) {
            graph.computeIfAbsent(prevNode, k -> new ArrayList<TreeNode>());
            graph.get(prevNode).add(currNode);
            graph.computeIfAbsent(currNode, k -> new ArrayList<TreeNode>());
            graph.get(currNode).add(prevNode);
        }
        traverseTree(currNode.left, currNode, graph, leafNodes);
        traverseTree(currNode.right, currNode, graph, leafNodes);
    }
}
