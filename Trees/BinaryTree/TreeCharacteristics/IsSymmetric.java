package Trees.BinaryTree.TreeCharacteristics;

import java.util.LinkedList;
import java.util.Queue;

import Trees.BinaryTree.Node;

public class IsSymmetric {
    public boolean isSymmetricBFS(Node root) {
        if (root == null) {
            return true;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);
        while (!q.isEmpty()) {
            Node a = q.poll();
            Node b = q.poll();
            if (a == null && b == null) {
                continue;
            }
            if (a == null || b == null) {
                return false;
            }
            if (a.data != b.data) {
                return false;
            }
            q.offer(a.left);
            q.offer(b.right);
            q.offer(a.right);
            q.offer(b.left);
        }
        return true;

    }

    public boolean isSymmetricRecursive(Node root) {
        if (root == null)
            return true;
        return check(root.left, root.right);
    }

    public boolean check(Node l, Node r) {
        if (l == null && r == null)
            return true;
        if (l == null || r == null || l.data != r.data)
            return false; // For all failing conditions
        return check(l.left, r.right) && check(l.right, r.left);
    }
}
