<b> Problem Statement </b> : https://leetcode.com/problems/linked-list-cycle-ii/description/

| Approach | Time Complexity | Space Complexity|
| :---:         |     :---:      |         :---: |
|  HashSet |  O(N)   |   O(N)    |
| Slow And Fast Pointer  | O(N) | O(1)  |


* Slow and Fast pointer approach is the optimal Solution.

### Detect Cycle

https://leetcode.com/problems/linked-list-cycle/description/

```
public boolean hasCycle(ListNode head) {
        ListNode slow = head;ListNode fast = head;
        while(fast!=null && fast.next!=null){
             slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) return true;
        }
        return false;
    }
```