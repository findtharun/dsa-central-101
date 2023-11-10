package Trees.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
public class VerticalOrderTraversal {
    class Tuple {
        Node node;
        int vert;
        int level;

        Tuple(int vert, int level, Node node) {
            this.vert = vert;
            this.level = level;
            this.node = node;
        }
    }

    class Solution {
        public List<List<Integer>> verticalTraversal(Node root) {
            List<List<Integer>> res = new ArrayList<>();
            Queue<Tuple> q = new LinkedList<Tuple>();
            // creating a map to store nodes at a particular horizontal distance.
            TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

            q.add(new Tuple(0, 0, root)); // vertical, level, node
            while (!q.isEmpty()) {
                Tuple curr = q.poll();
                Node currNode = curr.node;
                int vert = curr.vert;
                int level = curr.level;
                if (!map.containsKey(vert))
                    map.put(vert, new TreeMap<>());
                if (!map.get(vert).containsKey(level))
                    map.get(vert).put(level, new PriorityQueue<Integer>());
                map.get(vert).get(level).add(currNode.data);

                if (currNode.left != null)
                    q.add(new Tuple(vert - 1, level + 1, currNode.left));
                if (currNode.right != null)
                    q.add(new Tuple(vert + 1, level + 1, currNode.right));
            }

            for (TreeMap<Integer, PriorityQueue<Integer>> verticalMap : map.values()) {
                List<Integer> verticalPath = new ArrayList<>();
                for (PriorityQueue<Integer> levelNodes : verticalMap.values()) {
                    while (!levelNodes.isEmpty()) {
                        verticalPath.add(levelNodes.poll());
                    }
                }
                res.add(verticalPath);
            }
            return res;
        }
    }
}
