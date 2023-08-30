package LinkedLists.StartingPointOfCycle;

import java.util.HashSet;

public class Hashset {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> st=new HashSet<>();
        while(head != null) {
            if(st.contains(head)) return head;
            st.add(head);
            head = head.next;
        }
        return null;
        }
}
