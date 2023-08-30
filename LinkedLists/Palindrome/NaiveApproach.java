package LinkedLists.Palindrome;

public class NaiveApproach {
    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        int num = 0;
        int rev = 0;
        int mul = 1;

        while (temp != null) {
            num = num * 10 + temp.val;
            rev = rev + temp.val * mul;
            mul *= 10;

            temp = temp.next;
        }

        return num == rev;
    }
}
