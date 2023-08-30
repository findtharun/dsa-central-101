package LinkedLists.Palindrome;

import java.util.Stack;

public class StackApproach {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr.val);
            curr = curr.next;
        }
        while (head != null) {
            if (head.val != stack.pop())
                return false;
            head = head.next;
        }
        return true;
    }
}
