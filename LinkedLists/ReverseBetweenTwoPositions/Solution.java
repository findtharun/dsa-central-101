package LinkedLists.ReverseBetweenTwoPositions;

public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode leftPrev = dummy;
        ListNode curr = head;
        // Storing the Previous Node of Left
        for (int i = 0; i < left - 1; ++i) {
            leftPrev = curr;
            curr = curr.next;
        }
        // Reversing from Left to Right
        ListNode prev = null;
        for(int i=0;i<right-left+1;i++){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        leftPrev.next.next = curr;
        leftPrev.next = prev;
        return dummy.next;
    }
}
