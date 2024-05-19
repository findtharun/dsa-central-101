package LinkedLists.ReorderList;

/**
 * Find Middle of Linkedlist using Slow and Fast Pointers
 * Reverse LinkedList from Middle
 * Merge Reversed List
 */
public class SlowFastPointers {
    // Method to find the middle of the linked list
    public ListNode midNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // Method to reverse a linked list
    public ListNode reverse(ListNode head) {
        ListNode curr = head, prev = null, temp = null;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    // Method to reorder the linked list
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle of the list
        ListNode mid = midNode(head);
        ListNode nextToMid = mid.next;
        mid.next = null;

        // Step 2: Reverse the second half of the list
        ListNode p2 = reverse(nextToMid);
        ListNode p1 = head;

        // Step 3: Merge the two halves
        ListNode p1Next, p2Next;
        while (p1 != null && p2 != null) {
            p1Next = p1.next;
            p2Next = p2.next;

            p1.next = p2;
            if (p1Next == null) {
                break;
            }
            p2.next = p1Next;
            p1 = p1Next;
            p2 = p2Next;
        }
    }
}
