import java.util.*;

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {

        Set<Integer> first = new HashSet<>();
        Set<Integer> second = new HashSet<>();

        ListNode dummy = new ListNode();
        dummy.next = head;

        while(head != null) {
            
            if(first.contains(head.val)) second.add(head.val);
            first.add(head.val);

            head = head.next;
        
        }

        head = dummy;

        while(head.next != null) if(second.contains(head.next.val)) {
            head.next = head.next.next;
        } else {
            head = head.next;
        }
    
        return dummy.next;
    }

}
