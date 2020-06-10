public class Solution {

    public static void swap(ListNode node) {

        if(node.next == null || node.next.next == null) return;

        ListNode temp = node.next;

        node.next = node.next.next;
        temp.next = node.next.next;

        node.next.next = temp;

        swap(node.next.next);

    }

    public ListNode swapPairs(ListNode head) {
        
        ListNode dummy = new ListNode();
        dummy.next = head;

        swap(dummy);

        return dummy.next;
    }

}
