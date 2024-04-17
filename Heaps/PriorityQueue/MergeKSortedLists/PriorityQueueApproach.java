package Heaps.PriorityQueue.MergeKSortedLists;

import java.util.*;

class Pair {
    int ele;
    ListNode node;

    Pair(int ele, ListNode node) {
        this.ele = ele;
        this.node = node;
    }
}

public class PriorityQueueApproach {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.ele - b.ele);
        for (int i = 0; i < lists.length; i++) {
            ListNode temp = lists[i];
            while (temp != null) {
                pq.add(new Pair(temp.val, temp));
                temp = temp.next;
            }
        }
        if (pq.size() == 0)
            return null;
        ListNode dummy = new ListNode(-1);
        Pair headPair = pq.poll();
        dummy.next = headPair.node;
        ListNode temp = dummy.next;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            temp.next = curr.node;
            temp = temp.next;
        }
        temp.next = null;
        return dummy.next;
    }
}
