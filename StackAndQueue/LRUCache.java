package StackAndQueue;

import java.util.HashMap;

public class LRUCache {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int cap;
    HashMap<Integer, Node> m = new HashMap<>();

    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    private void addNode(Node newnode) {
        Node temp = head.next;

        newnode.next = temp;
        newnode.prev = head;

        head.next = newnode;
        temp.prev = newnode;
    }

    private void deleteNode(Node delnode) {
        Node prevv = delnode.prev;
        Node nextt = delnode.next;

        prevv.next = nextt;
        nextt.prev = prevv;
    }

    public int get(int key) {
        if (m.containsKey(key)) {
            Node resNode = m.get(key); // We will get Node associated to Key
            int ans = resNode.val;
            m.remove(key);
            deleteNode(resNode); // Delete Old Connction
            addNode(resNode); // Add as New connection at Start (Since it is LRU)
            m.put(key, head.next);
            return ans;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (m.containsKey(key)) {
            Node curr = m.get(key);
            m.remove(key);
            deleteNode(curr);
        }
        if (m.size() == cap) { // Reached Capacity
            m.remove(tail.prev.key); // Removing the Less USed Node
            deleteNode(tail.prev); // Deleting Node
        }
        addNode(new Node(key, value));
        m.put(key, head.next);
    }
}
