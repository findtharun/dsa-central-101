package LinkedLists.Palindrome;

public class SlowAndFastPointer {
    public ListNode findMiddle(ListNode head){
        ListNode slow = head; ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseLL(ListNode head){
        ListNode curr = head;
        ListNode prev =  null;
        ListNode temp = null;
        while(curr!=null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr =  temp;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode mid = findMiddle(head);
        ListNode firstHalf = head;
        ListNode secondHalf = reverseLL(mid);
        while(secondHalf!=null){
            if(firstHalf.val!=secondHalf.val) return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
    return true;
    }
}
