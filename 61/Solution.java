public class Solution {

    public ListNode rotateRight(ListNode head, int k) {

        if(head == null) return null;

        ListNode dummy = new ListNode();
        dummy.next = head;

        int n = 1;
        while(head.next != null) {
            head = head.next;
            n++;
        }

        head.next = dummy.next;
        dummy = head;

        while(k++ % n != 0) dummy = dummy.next;

        head = dummy.next;
        dummy.next = null;

        return head;
    }

}
