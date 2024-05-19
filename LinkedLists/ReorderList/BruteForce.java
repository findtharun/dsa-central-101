package LinkedLists.ReorderList;

import java.util.*;

public class BruteForce {
    public void reorderList(ListNode head) {
        List<ListNode> arr = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            arr.add(temp);
            temp = temp.next;
        }
        int n = arr.size();
        int left = 0;
        int right = n - 1;
        while (left < right) {
            arr.get(left).next = arr.get(right);
            left++;
            if (left == right)
                break;
            arr.get(right).next = arr.get(left);
            right--;
        }
        arr.get(left).next = null;
    }
}
