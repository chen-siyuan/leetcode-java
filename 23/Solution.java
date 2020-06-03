public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        int min;
        int index = 0;

        while(index != -1) {
        
            min = Integer.MAX_VALUE;
            index = -1;

            for(int i=0; i < lists.length; i++) if(lists[i] != null && lists[i].val < min) {
                min = lists[i].val;
                index = i;
            }

            if(index != -1) {

                curr.next = new ListNode(lists[index].val);
                curr = curr.next;

                lists[index] = lists[index].next;

            }
        
        }
        
        return dummy.next;
    }

}
