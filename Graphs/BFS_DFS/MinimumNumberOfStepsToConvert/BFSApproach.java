package Graphs.BFS_DFS.MinimumNumberOfStepsToConvert;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class Node {
    int val;
    int steps;

    public Node(int val, int steps) {
        this.val = val;
        this.steps = steps;
    }
}

public class BFSApproach {
    private static int minOperations(int src, int target) {

        Set<Integer> visited = new HashSet<>(1000);
        LinkedList<Node> queue = new LinkedList<Node>();

        Node node = new Node(src, 0);

        queue.offer(node);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (visited.contains(temp.val) == false) {
                visited.add(temp.val);
            }

            if (temp.val == target) {
                return temp.steps;
            }

            int mul = temp.val * 2;
            int sub = temp.val - 1;

            // given constraints
            if (mul > 0 && mul < 1000) {
                Node nodeMul = new Node(mul, temp.steps + 1);
                queue.offer(nodeMul);
            }
            if (sub > 0 && sub < 1000) {
                Node nodeSub = new Node(sub, temp.steps + 1);
                queue.offer(nodeSub);
            }
        }
        return -1;
    }

    // Driver code
    public static void main(String[] args) {
        // int x = 2, y = 5;
        int x = 4, y = 7;
        System.out.println(minOperations(x, y));
    }
}
