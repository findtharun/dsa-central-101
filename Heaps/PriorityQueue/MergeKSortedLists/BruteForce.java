package Heaps.PriorityQueue.MergeKSortedLists;

import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class BruteForce {
    public ListNode mergeKLists(ListNode[] lists) {
        // Each Item is a LInkedList,
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            ListNode temp = lists[i]; // Linkedlist Head
            while (temp != null) {
                arr.add(temp.val);
                temp = temp.next;
            }
        }
        Collections.sort(arr);
        if (arr.size() == 0)
            return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = new ListNode(arr.get(0));
        ListNode temp = dummy.next;
        for (int i = 1; i < arr.size(); i++) {
            temp.next = new ListNode(arr.get(i));
            temp = temp.next;
        }

        return dummy.next;

    }
}
