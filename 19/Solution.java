public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
    
        ListNode dummy = new ListNode();
        dummy.next = head;
    
        ListNode fast = head;
        while(n-- != 0) fast = fast.next;

        ListNode slow = dummy;

        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }

}
