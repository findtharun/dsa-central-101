package LinkedLists.AddTwoNumbers;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dumy = new ListNode();
        ListNode curr= dumy;
        int carry =0;
        while(l1!=null || l2!=null || carry==1){
            int sum = 0;
            if(l1!=null){
                sum = sum + l1.val;
                l1 = l1.next;
            }
              if(l2!=null){
                sum = sum + l2.val;
                l2 = l2.next;
            }
            sum = sum + carry;
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
        }
        return dumy.next;
    }
}
